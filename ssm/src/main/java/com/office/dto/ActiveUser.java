package com.office.dto;

import java.io.Serializable;
import java.util.List;

import com.office.entity.TPermission;
import com.office.entity.TRole;

public class ActiveUser implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String idUser;// 用户id（主键）
	private String username;// 用户名称

	private List<TPermission> permissions;// 菜单
	private List<TRole> roles;// 权限

	public String getIdUser() {
		return idUser;
	}

	public void setIdUser(String idUser) {
		this.idUser = idUser;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<TPermission> getPermissions() {
		return permissions;
	}

	public void setPermissions(List<TPermission> permissions) {
		this.permissions = permissions;
	}

	public List<TRole> getRoles() {
		return roles;
	}

	public void setRoles(List<TRole> roles) {
		this.roles = roles;
	}

}
