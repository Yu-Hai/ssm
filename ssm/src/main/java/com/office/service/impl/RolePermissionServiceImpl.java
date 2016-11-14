package com.office.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.office.common.bean.ReturnData;
import com.office.common.exception.BusinessException;
import com.office.common.service.impl.BaseServiceImpl;
import com.office.dao.IRolePermissionDao;
import com.office.entity.TRolePermission;
import com.office.service.IRolePermissionService;

@Service
public class RolePermissionServiceImpl extends BaseServiceImpl<TRolePermission> implements IRolePermissionService {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	IRolePermissionDao rolePermissionDao;

	@Override
	public ReturnData correlationPermissions(String idRole,String[] idPermissions) throws BusinessException {
		logger.info("correlationPermissions入参=====>>>:idRole:"+idRole+"，idPermissions："+idPermissions);
		ReturnData returnData=new ReturnData();
		boolean result=rolePermissionDao.correlationPermissions(idRole, idPermissions)>0 ? true : false;
		returnData.setSuccess(result);
		if(result)
			returnData.setComment("添加角色-权限之间关系成功!");
		else
			returnData.setComment("添加角色-权限之间关系失败!");
		logger.info("correlationPermissions出参=====>>>:"+returnData);
		return returnData;
	}

	@Override
	public ReturnData uncorrelationPermissions(String idRole,String[] idPermissions) throws BusinessException {
		logger.info("uncorrelationPermissions入参=====>>>:idRole:"+idRole+"，idPermissions："+idPermissions);
		ReturnData returnData=new ReturnData();
		boolean result=rolePermissionDao.uncorrelationPermissions(idRole, idPermissions)>0 ? true : false;
		returnData.setSuccess(result);
		if(result)
			returnData.setComment("移除角色-权限之间关系成功!");
		else
			returnData.setComment("移除角色-权限之间关系失败!");
		logger.info("uncorrelationPermissions出参=====>>>:"+returnData);
		return returnData;
	}

}
