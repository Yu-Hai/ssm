package com.office.dao;

import java.util.List;
import java.util.Set;

import com.office.common.dao.IBaseDao;
import com.office.entity.TRole;
import com.office.entity.TUser;

public interface IRoleDao extends IBaseDao<TRole> {
	
	List<TRole> findRolesByUser(TUser user);
}
