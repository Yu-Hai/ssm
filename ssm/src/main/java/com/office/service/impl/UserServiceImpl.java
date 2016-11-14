package com.office.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.office.common.bean.ReturnData;
import com.office.common.exception.BusinessException;
import com.office.common.service.impl.BaseServiceImpl;
import com.office.dao.IUserDao;
import com.office.entity.TUser;
import com.office.service.IUserService;

@Service
public class UserServiceImpl extends BaseServiceImpl<TUser> implements IUserService {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	

	@Autowired
	private IUserDao userDao;

	@Override
	public ReturnData registerUser(TUser user) throws BusinessException {
		logger.info("registerUser入参=====>>>:"+user);
		ReturnData returnData=new ReturnData();
		boolean result=userDao.insert(user)>0 ? true : false;
		returnData.setSuccess(result);
		if(result)
			returnData.setComment("用户注册成功=====>>>："+user);
		else
			returnData.setComment("用户注册失败=====>>>："+user);
		logger.info("registerUser出参=====>>>:"+returnData);
		return returnData;
	}

	@Override
	public TUser findByUserName(TUser user) throws BusinessException {
		logger.info("findByUserName入参=====>>>:"+user);
		TUser result=userDao.findByUserName(user);
		logger.info("registerUser出参=====>>>:"+result);
		return result;
	}
}
