package com.office.test.dao;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.office.common.exception.BusinessException;
import com.office.entity.TPermission;
import com.office.entity.TUser;
import com.office.service.IPermissionService;

public class PermissionTest extends BaseTest {

	@Autowired
	IPermissionService permissionService;
	
	@Test
	public void test(){
		TUser user=new TUser();
		user.setIdUser("1");
		List<TPermission> permissions = null;
		try {
			permissions = permissionService.findPermissionByUser(user);
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (TPermission tPermission : permissions) {
			System.out.println(tPermission);
		}
	}
}
