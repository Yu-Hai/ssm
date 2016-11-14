package com.office.entity;

import java.util.List;

public class TConst {

	private String idConst;

	private String value;

	private String code;

	private String type;

	private TConst parentConst;

	private List<TConst> childConsts;

	private String description;

	public TConst() {
	}

	public String getIdConst() {
		return idConst;
	}

	public void setIdConst(String idConst) {
		this.idConst = idConst;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public TConst getParentConst() {
		return parentConst;
	}

	public void setParentConst(TConst parentConst) {
		this.parentConst = parentConst;
	}

	public List<TConst> getChildConsts() {
		return childConsts;
	}

	public void setChildConsts(List<TConst> childConsts) {
		this.childConsts = childConsts;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public TConst(String type) {
		this.type = type;
	}

	public TConst(String idConst, String value, String code, String type,
			TConst parentConst, List<TConst> childConsts, String description) {
		this.idConst = idConst;
		this.value = value;
		this.code = code;
		this.type = type;
		this.parentConst = parentConst;
		this.childConsts = childConsts;
		this.description = description;
	}

}
