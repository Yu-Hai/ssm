package com.office.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.office.common.exception.BusinessException;
import com.office.common.service.impl.BaseServiceImpl;
import com.office.dao.IPermissionDao;
import com.office.entity.TPermission;
import com.office.entity.TUser;
import com.office.service.IPermissionService;

@Service
public class PermissionServiceImpl extends BaseServiceImpl<TPermission> implements IPermissionService {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	IPermissionDao permissionDao;
	
	@Override
	public List<TPermission> findPermissionByUser(TUser user) throws BusinessException {
		logger.info("findPermissionByUser入参=====>>>:"+user);
		List<TPermission> permissions = null;
		try {
			permissions = permissionDao.findPermissionByUser(user);
		} catch (Exception e) {
			logger.error("findPermissionByUser 失败！",e);
			throw new BusinessException("findPermissionByUser 失败！");
		}
		logger.info("findPermissionByUser出参=====>>>:"+permissions);
		return permissions;
	}

}
