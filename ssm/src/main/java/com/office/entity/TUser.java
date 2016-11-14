package com.office.entity;

public class TUser {

	private String idUser;
	private String username;
	private String password;
	private String salt;
	private Boolean locked = Boolean.FALSE;

	public TUser() {}
	
	

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getCredentialsSalt() {
		return username + salt;
	}

	public Boolean getLocked() {
		return locked;
	}

	public void setLocked(Boolean locked) {
		this.locked = locked;
	}

	public TUser(String idUser, String username, String password, String salt,
			Boolean locked) {
		super();
		this.idUser = idUser;
		this.username = username;
		this.password = password;
		this.salt = salt;
		this.locked = locked;
	}

	@Override
	public String toString() {
		return "TUser [idUser=" + idUser + ", username=" + username
				+ ", password=" + password + ", salt=" + salt + ", locked="
				+ locked + "]";
	}

	public TUser(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

}
