package com.office.service;

import java.util.List;

import com.office.common.exception.BusinessException;
import com.office.common.service.IBaseService;
import com.office.entity.TPermission;
import com.office.entity.TUser;

public interface IPermissionService extends IBaseService<TPermission> {

	List<TPermission> findPermissionByUser(TUser user) throws BusinessException;
	
}
