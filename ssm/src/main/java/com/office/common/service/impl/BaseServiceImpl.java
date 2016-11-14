package com.office.common.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.office.common.bean.ReturnData;
import com.office.common.dao.IBaseDao;
import com.office.common.exception.BusinessException;
import com.office.common.service.IBaseService;

@Service
public class BaseServiceImpl<T> implements IBaseService<T> {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private IBaseDao<T> baseDao;
	
	/**
	 * 新增
	 */
	@Override
	public ReturnData insert(T t) throws BusinessException {
		logger.info("insert入参=====>>>:"+t);
		ReturnData returnData=new ReturnData();
		boolean result=baseDao.insert(t)>0 ? true : false;
		returnData.setSuccess(result);
		if(result)
			returnData.setComment("插入"+t.getClass()+"成功！");
		else
			returnData.setComment("插入"+t.getClass()+"失败！");
		logger.info("insert出参=====>>>:"+returnData);
		return returnData;
	}

	@Override
	public ReturnData delete(T t) throws BusinessException {
		logger.info("delete入参=====>>>:"+t);
		ReturnData returnData=new ReturnData();
		boolean result=baseDao.delete(t)>0 ? true : false;
		returnData.setSuccess(result);
		if(result)
			returnData.setComment("删除"+t.getClass()+"成功！");
		else
			returnData.setComment("删除"+t.getClass()+"失败！");
		logger.info("delete出参=====>>>:"+returnData);
		return returnData;
	}

	@Override
	public ReturnData batchDelete(T[] info) throws BusinessException {
		logger.info("batchDelete入参=====>>>:"+info);
		ReturnData returnData=new ReturnData();
		boolean result=baseDao.batchDelete(info)>0 ? true : false;
		returnData.setSuccess(result); 
		if(result)
			returnData.setComment("批量删除"+info.getClass()+"成功！");
		else
			returnData.setComment("批量删除"+info.getClass()+"失败！");
		logger.info("batchDelete出参=====>>>:"+returnData);
		return returnData;
	}

	@Override
	public ReturnData update(T t) throws BusinessException {
		logger.info("update入参=====>>>:"+t);
		ReturnData returnData=new ReturnData();
		boolean result=baseDao.update(t)>0 ? true : false;
		returnData.setSuccess(result);
		if(result)
			returnData.setComment("修改"+t.getClass()+"成功！");
		else
			returnData.setComment("修改"+t.getClass()+"失败！");
		logger.info("update出参=====>>>:"+returnData);
		return returnData;
	}

	@Override
	public List<T> findAll() throws BusinessException {
		List<T> list=baseDao.findAll();
		logger.info("findAll出参=====>>>:"+list);
		return list;
	}

	@Override
	public T findById(T t) throws BusinessException {
		logger.info("findById入参=====>>>:"+t);
		T obj=baseDao.findById(t);
		logger.info("findById出参=====>>>:"+obj);
		return obj;
	}

	@Override
	public List<T> getListByObj(T t) throws BusinessException {
		logger.info("getListByObj入参=====>>>:"+t);
		List<T> list=baseDao.getListByObj(t);
		logger.info("getListByObj出参=====>>>:"+list);
		return list;
	}

	@Override
	public Integer getCountByObj(T t) throws BusinessException {
		logger.info("getCountByObj入参=====>>>:"+t);
		Integer count=baseDao.getCountByObj(t);
		logger.info("getCountByObj出参=====>>>:"+count);
		return count;
	}

	@Override
	public T findByObj(T t) throws BusinessException {
		logger.info("findByObj入参=====>>>:"+t);
		T obj=baseDao.findByObj(t);
		logger.info("findByObj出参=====>>>:"+obj);
		return obj;
	}

}
