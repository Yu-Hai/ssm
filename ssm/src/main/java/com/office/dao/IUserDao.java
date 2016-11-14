package com.office.dao;

import com.office.common.dao.IBaseDao;
import com.office.entity.TUser;

public interface IUserDao extends IBaseDao<TUser> {
	
	TUser findByUserName(TUser user);
	

}
