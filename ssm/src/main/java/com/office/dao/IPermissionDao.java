package com.office.dao;

import java.util.List;

import com.office.common.dao.IBaseDao;
import com.office.entity.TPermission;
import com.office.entity.TUser;

public interface IPermissionDao extends IBaseDao<TPermission> {
	
	List<TPermission> findPermissionByUser(TUser user);

}
