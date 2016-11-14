package com.office.common.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;
import org.springframework.web.servlet.ModelAndView;

import com.office.common.config.GlobalValueConfig;
import com.office.entity.TUser;
//控制器基础类
public abstract class BaseController implements MessageSourceAware {

	protected MessageSource messageSource;
	public static final String RESPONS_ECODE = "responseCode";
	public static final String RESPONS_EMSG = "responseMsg";

	public static final String DATA_LIST = "dataList";
	public static final String DATA = "data";
	public static final String DATA_COUNT = "dataCount";

	public static final String SUCCESS_CODE = "0000";
	public static final String FAILED_CODE = "1111";

	public static final String ERROR_FORWARD = "/error";



	public Map<String, Object> successJson(Object result) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(RESPONS_ECODE, SUCCESS_CODE);
		map.put(DATA, result);
		return map;
	}
	
	public Map<String, Object> successJson() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(RESPONS_ECODE, SUCCESS_CODE);
		return map;
	}
	public Map<String, Object> failedJson(String message) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(RESPONS_ECODE, FAILED_CODE);
		map.put(RESPONS_EMSG, message);
		return map;
	}

	
	public ModelAndView success(List<?> results, int count, String viewName) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName(this.getForwardPrefix()==null?"":this.getForwardPrefix()+"/"+viewName);

		Map<String, Object> map = new HashMap<String, Object>();
		map.put(RESPONS_ECODE, SUCCESS_CODE);
		map.put(DATA_LIST, results);
		map.put(DATA_COUNT, count);
		mv.addAllObjects(map);

		return mv;
	}
	
	public ModelAndView fail(String responseCode) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName(ERROR_FORWARD);

		Map<String, Object> map = new HashMap<String, Object>();
		map.put(RESPONS_ECODE, responseCode);
		map.put(RESPONS_EMSG, GlobalValueConfig.getMsgByCode(responseCode, ""));
		mv.addAllObjects(map);

		return mv;
	}

	public ModelAndView fail(String responseCode, String responseMsg) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName(ERROR_FORWARD);

		Map<String, Object> map = new HashMap<String, Object>();
		map.put(RESPONS_ECODE, responseCode);
		map.put(RESPONS_EMSG, GlobalValueConfig.getMsgByCode(responseCode, responseMsg));

		mv.addAllObjects(map);
		return mv;
	}

	public ModelAndView success(String viewName) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName(this.getForwardPrefix()+"/"+viewName);

		Map<String, Object> map = new HashMap<String, Object>();
		map.put(RESPONS_ECODE, SUCCESS_CODE);
		mv.addAllObjects(map);
		return mv;
	}

	public ModelAndView success(Object data, String viewName) {

		//创建ModelAndView
		ModelAndView mv = new ModelAndView();
		mv.setViewName(this.getForwardPrefix()+"/"+viewName);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(RESPONS_ECODE, SUCCESS_CODE);
		map.put(DATA, data);
		mv.addAllObjects(map);

		return mv;
	}

	public ModelAndView data(String key, Object data, String viewName) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName(this.getForwardPrefix()+"/"+viewName);

		Map<String, Object> map = new HashMap<String, Object>();
		map.put(RESPONS_ECODE, SUCCESS_CODE);
		map.put(key, data);
		mv.addAllObjects(map);

		return mv;
	}

	public ModelAndView fail(String code, Object[] args, String viewName) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName(viewName);

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("failure", true);
		String message = messageSource.getMessage(code, args, "Fail!", null);
		map.put("msg", message);

		mv.addAllObjects(map);

		return mv;
	}

	@Override
	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}


	public TUser getCurrentUser(HttpServletRequest request) {

		TUser user = (TUser) request.getSession().getAttribute("user");
		return user;

	}
	
	protected abstract String getForwardPrefix();

	public ModelAndView createModelAndView(String viewPath) {

		return new ModelAndView(this.getForwardPrefix() + "/"+viewPath);
	}

}
