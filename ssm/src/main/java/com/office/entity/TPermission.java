package com.office.entity;

import java.util.ArrayList;
import java.util.List;

public class TPermission {

	private String idPermission;
	private TPermission parentPermission;
	private String permission; // 权限标识 程序中判断使用,如"user:create"
	private String type;
	private Integer sort;
	private String url;
	private String icon;
	private String description; // 权限描述,UI界面显示使用
	private Boolean available = Boolean.FALSE; // 是否可用,如果不可用将不会添加给用户
	private List<TPermission> childPermissions = new ArrayList<TPermission>();

	public String getIdPermission() {
		return idPermission;
	}

	public void setIdPermission(String idPermission) {
		this.idPermission = idPermission;
	}

	public TPermission getParentPermission() {
		return parentPermission;
	}

	public void setParentPermission(TPermission parentPermission) {
		this.parentPermission = parentPermission;
	}

	public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getAvailable() {
		return available;
	}

	public void setAvailable(Boolean available) {
		this.available = available;
	}

	public List<TPermission> getChildPermissions() {
		return childPermissions;
	}

	public void setChildPermissions(List<TPermission> childPermissions) {
		this.childPermissions = childPermissions;
	}
	
	

}
