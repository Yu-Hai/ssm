package com.office.service;

import com.office.common.bean.ReturnData;
import com.office.common.exception.BusinessException;
import com.office.common.service.IBaseService;
import com.office.entity.TUser;

public interface IUserService extends IBaseService<TUser> {
	
	ReturnData registerUser(TUser user) throws BusinessException;
	
	TUser findByUserName(TUser user)throws BusinessException;

}
