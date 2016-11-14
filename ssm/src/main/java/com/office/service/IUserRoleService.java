package com.office.service;

import com.office.common.bean.ReturnData;
import com.office.common.exception.BusinessException;
import com.office.common.service.IBaseService;
import com.office.entity.TUserRole;

public interface IUserRoleService extends IBaseService<TUserRole> {
	
	/**
	 * 添加用户-角色关系  
	 * @param idUser
	 * @param idRoles
	 * @return
	 */
	ReturnData correlationRoles(String idUser, String[] idRoles)throws BusinessException; 
	
	/**
	 * 移除用户-角色关系  
	 * @param idUser
	 * @param idRoles
	 * @return
	 */
    ReturnData uncorrelationRoles(String idUser, String[] idRoles)throws BusinessException;

}
