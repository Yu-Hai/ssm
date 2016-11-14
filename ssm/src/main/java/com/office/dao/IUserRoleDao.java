package com.office.dao;

import com.office.common.dao.IBaseDao;
import com.office.entity.TUserRole;

public interface IUserRoleDao extends IBaseDao<TUserRole> {
	
	/**
	 * 添加用户-角色关系  
	 * @param idUser
	 * @param idRoles
	 * @return
	 */
	Integer correlationRoles(String idUser, String[] idRoles); 
	
	/**
	 * 移除用户-角色关系  
	 * @param idUser
	 * @param idRoles
	 * @return
	 */
    Integer uncorrelationRoles(String idUser, String[] idRoles);

}
