package com.office.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.office.common.constant.CommonConstants;
import com.office.common.controller.BaseController;
import com.office.common.exception.BusinessException;
import com.office.dto.Chengyu;
import com.office.entity.TChengyu;
import com.office.entity.TConst;
import com.office.service.IChengyuService;
import com.office.service.IConstService;
import com.office.util.BeanUtils;
import com.office.util.StringUtil;

@Controller
@RequestMapping("/chengyu")
public class ChengyuController extends BaseController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	IChengyuService chengyuService;

	@Autowired
	IConstService constService;

	@RequestMapping("/index")
	private ModelAndView index(Chengyu chengyu) {
		logger.info("index 入参=====>>>:" + chengyu);
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			List<TConst> consts = constService.getListByObj(new TConst(
					CommonConstants.ALL_ENGLISH));
			result.put("consts", consts);
		} catch (BusinessException e) {
			logger.error("查询所有的成语列表失败！" + e);
		}
		logger.info("index 出参=====>>>:成功！");
		return success(result, "ajaxPage");
	}

	@RequestMapping("/loadData")
	@ResponseBody
	private Map<String, Object> loadData(Chengyu chengyu) {
		logger.info("loadData 入参=====>>>:" + chengyu);
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			List<TChengyu> chengyus = null;
			if (!StringUtils.isEmpty(chengyu.getChengyu())
					&& StringUtils.isEmpty(chengyu.getStart())
					&& StringUtil.isLetter(chengyu.getChengyu())) {
				chengyu.setModel(chengyu.getChengyu());
				Integer pageNo=chengyu.getPageNo();
				Integer totalSize=chengyuService.findCountByModel(chengyu);
				chengyus = chengyuService.findChengyuByModel(chengyu);
				result.put("totalSize", totalSize);
				result.put("pageNo", pageNo);
			} else {
				if (BeanUtils.checkFieldValueNull(chengyu)) {
					chengyu.setStart("a");// 设置默认值
				}
				chengyus = chengyuService.findChengyuByChengyu(chengyu);
			}

			result.put("chengyus", chengyus);
		} catch (BusinessException e) {
			logger.error("查询所有的成语列表失败！" + e);
		}
		logger.info("loadData 出参=====>>>:成功！");
		return successJson(result);
	}

	@RequestMapping("/fileUpload")
	@ResponseBody
	public void fileUpload(MultipartHttpServletRequest multipartRequest,
			HttpServletResponse response) throws Exception {
		response.setContentType("text/html;charset=UTF-8");
		Map<String, Object> result = new HashMap<String, Object>();
		// 获取多个file
		for (Iterator it = multipartRequest.getFileNames(); it.hasNext();) {
			String key = (String) it.next();
			MultipartFile imgFile = multipartRequest.getFile(key);
			if (imgFile.getOriginalFilename().length() > 0) {
				String fileName = imgFile.getOriginalFilename();
				// 改成自己的对象哦！
				Object obj = new Object();
				// Constant.UPLOAD_GOODIMG_URL 是一个配置文件路径
				try {
					String uploadFileUrl = multipartRequest.getSession()
							.getServletContext()
							.getRealPath(CommonConstants.UPLOAD_URL);
					File _apkFile = saveFileFromInputStream(
							imgFile.getInputStream(), uploadFileUrl, fileName);
					if (_apkFile.exists()) {
						FileInputStream fis = new FileInputStream(_apkFile);
					} else
						throw new FileNotFoundException("apk write failed:"
								+ fileName);
					List list = new ArrayList();
					// 将obj文件对象添加到list
					list.add(obj);
					result.put("success", true);
				} catch (Exception e) {
					result.put("success", false);
					e.printStackTrace();
				}
			}
		}
		String json = new Gson().toJson(result,
				new TypeToken<Map<String, Object>>() {
				}.getType());
		response.getWriter().print(json);
	}

	// 保存文件
	private File saveFileFromInputStream(InputStream stream, String path,
			String filename) throws IOException {
		File file = new File(path + "/" + filename);
		FileOutputStream fs = new FileOutputStream(file);
		byte[] buffer = new byte[1024 * 1024];
		int bytesum = 0;
		int byteread = 0;
		while ((byteread = stream.read(buffer)) != -1) {
			bytesum += byteread;
			fs.write(buffer, 0, byteread);
			fs.flush();
		}
		fs.close();
		stream.close();
		return file;
	}

	@Override
	protected String getForwardPrefix() {
		return "chengyu";
	}

}
