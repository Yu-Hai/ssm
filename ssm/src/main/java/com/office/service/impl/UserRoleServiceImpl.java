package com.office.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.office.common.bean.ReturnData;
import com.office.common.exception.BusinessException;
import com.office.common.service.impl.BaseServiceImpl;
import com.office.dao.IUserRoleDao;
import com.office.entity.TUserRole;
import com.office.service.IUserRoleService;

@Service
public class UserRoleServiceImpl extends BaseServiceImpl<TUserRole> implements IUserRoleService {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	IUserRoleDao userRoleDao;
	
	@Override
	public ReturnData correlationRoles(String idUser, String[] idRoles) throws BusinessException {
		logger.info("correlationRoles入参=====>>>:idUser:"+idUser+"，idRoles："+idRoles);
		ReturnData returnData=new ReturnData();
		boolean result=userRoleDao.correlationRoles(idUser, idRoles)>0 ? true : false;
		returnData.setSuccess(result);
		if(result)
			returnData.setComment("添加用户-角色关系 成功!");
		else
			returnData.setComment("添加用户-角色关系 失败!");
		logger.info("correlationRoles出参=====>>>:"+returnData);
		return returnData;
	}

	@Override
	public ReturnData uncorrelationRoles(String idUser, String[] idRoles) throws BusinessException {
		logger.info("uncorrelationRoles入参=====>>>:idUser:"+idUser+"，idRoles："+idRoles);
		ReturnData returnData=new ReturnData();
		boolean result=userRoleDao.uncorrelationRoles(idUser, idRoles)>0 ? true : false;
		returnData.setSuccess(result);
		if(result)
			returnData.setComment("移除用户-角色关系成功!");
		else
			returnData.setComment("移除用户-角色关系失败!");
		logger.info("uncorrelationRoles出参=====>>>:"+returnData);
		return returnData;
	}
	


}
