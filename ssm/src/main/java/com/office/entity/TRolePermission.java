package com.office.entity;

public class TRolePermission {

	private String idRole;

	private String idPermission;

	public String getIdRole() {
		return idRole;
	}

	public void setIdRole(String idRole) {
		this.idRole = idRole;
	}

	public String getIdPermission() {
		return idPermission;
	}

	public void setIdPermission(String idPermission) {
		this.idPermission = idPermission;
	}

	@Override
	public String toString() {
		return "TRolePermission [idRole=" + idRole + ", idPermission="
				+ idPermission + "]";
	}

}
