package com.office.service;

import com.office.common.bean.ReturnData;
import com.office.common.exception.BusinessException;
import com.office.common.service.IBaseService;
import com.office.entity.TRolePermission;

public interface IRolePermissionService extends IBaseService<TRolePermission> {
	
	/**
	 * 添加角色-权限之间关系  
	 * @param idRole
	 * @param idPermissions
	 * @return
	 * @throws BusinessException
	 */
    ReturnData correlationPermissions(String idRole, String[] idPermissions)throws BusinessException; 
    
    /**
     * 移除角色-权限之间关系  
     * @param idRole
     * @param idPermissions
     * @return
     * @throws BusinessException
     */
    ReturnData uncorrelationPermissions(String idRole, String[] idPermissions)throws BusinessException;

}
