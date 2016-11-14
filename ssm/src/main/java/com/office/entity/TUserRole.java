package com.office.entity;

public class TUserRole {

	private String idUser;

	private String idRole;

	public String getIdUser() {
		return idUser;
	}

	public void setIdUser(String idUser) {
		this.idUser = idUser;
	}

	public String getIdRole() {
		return idRole;
	}

	public void setIdRole(String idRole) {
		this.idRole = idRole;
	}

	@Override
	public String toString() {
		return "TUserRole [idUser=" + idUser + ", idRole=" + idRole + "]";
	}

}
