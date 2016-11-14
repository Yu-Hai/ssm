package com.office.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.office.common.exception.BusinessException;
import com.office.common.service.impl.BaseServiceImpl;
import com.office.dao.IChengyuDao;
import com.office.dto.Chengyu;
import com.office.entity.TChengyu;
import com.office.service.IChengyuService;

@Service
public class ChengyuServiceImpl extends BaseServiceImpl<TChengyu> implements IChengyuService {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	IChengyuDao chengyuDao;

	@Override
	public List<TChengyu> findChengyuByChengyu(Chengyu chengyu) throws BusinessException {
		logger.info("findChengyuByChengyu 入参=====>>>:"+chengyu);
		List<TChengyu> result=null;
		try {
			result=chengyuDao.findChengyuByChengyu(chengyu);
		} catch (Exception e) {
			logger.error("findChengyuByChengyu 查询成语失败！",e);
			throw new BusinessException("findChengyuByChengyu 查询成语失败！",e);
		}
		logger.info("findChengyuByChengyu 出参=====>>>:成功！");
		return result;
	}

	@Override
	public List<TChengyu> findChengyuByModel(Chengyu chengyu) throws BusinessException {
		logger.info("findChengyuByModel 入参=====>>>:"+chengyu);
		List<TChengyu> result=null;
		try {
			chengyu.setPageNo(chengyu.getPageNo()==null?1:chengyu.getPageNo());
			chengyu.setPageSize(chengyu.getPageSize()==null?5:chengyu.getPageSize());
			Integer pageNo=(chengyu.getPageNo()-1)*chengyu.getPageSize();
			chengyu.setPageNo(pageNo);
			result=chengyuDao.findChengyuByModel(chengyu);
		} catch (Exception e) {
			logger.error("findChengyuByModel 查询成语失败！",e);
			throw new BusinessException("findChengyuByChengyu 查询成语失败！",e);
		}
		logger.info("findChengyuByModel 出参=====>>>:成功！");
		return result;
	}

	@Override
	public Integer findCountByModel(Chengyu chengyu) throws BusinessException {
		logger.info("findCountByModel 入参=====>>>:"+chengyu);
		Integer result=null;
		try {
			result=chengyuDao.findCountByModel(chengyu);
		} catch (Exception e) {
			logger.error("findCountByModel 查询成语总条数失败！",e);
			throw new BusinessException("findCountByModel 查询成语总条数失败！",e);
		}
		logger.info("findCountByModel 出参=====>>>:成功！");
		return result;
	}

}
