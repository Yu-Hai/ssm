package com.office.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.office.common.exception.BusinessException;
import com.office.common.service.impl.BaseServiceImpl;
import com.office.dao.IRoleDao;
import com.office.entity.TRole;
import com.office.entity.TUser;
import com.office.service.IRoleService;

@Service
public class RoleServiceImpl extends BaseServiceImpl<TRole> implements IRoleService {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	IRoleDao roleDao;

	@Override
	public List<TRole> findRolesByUser(TUser user) throws BusinessException {
		logger.info("findRolesByUser 入参=====>>>:"+user);
		List<TRole> result=null;
		try {
			result=roleDao.findRolesByUser(user);
		} catch (Exception e) {
			logger.error("findRolesByUser 查询角色列表失败！",e);
			throw new BusinessException("findRolesByUser 查询角色列表失败！",e);
		}
		logger.info("findRolesByUser 出参=====>>>:成功！");
		return result;
	}

}
