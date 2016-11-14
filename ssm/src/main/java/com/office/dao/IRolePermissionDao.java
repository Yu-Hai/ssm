package com.office.dao;

import com.office.common.dao.IBaseDao;
import com.office.entity.TRolePermission;

public interface IRolePermissionDao extends IBaseDao<TRolePermission> {
	
	//添加角色-权限之间关系  
    Integer correlationPermissions(String idRole, String[] idPermissions); 
    
    //移除角色-权限之间关系  
    Integer uncorrelationPermissions(String idRole, String[] idPermissions);

}
