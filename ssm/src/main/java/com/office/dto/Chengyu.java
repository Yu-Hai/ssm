package com.office.dto;

import com.office.common.bean.Page;

public class Chengyu extends Page {

	private String chengyu;

	private String spinyin;

	private String start;

	private String model;
	
	public String getChengyu() {
		return chengyu;
	}

	public void setChengyu(String chengyu) {
		this.chengyu = chengyu;
	}

	public String getSpinyin() {
		return spinyin;
	}

	public void setSpinyin(String spinyin) {
		this.spinyin = spinyin;
	}

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	@Override
	public String toString() {
		return "Chengyu [chengyu=" + chengyu + ", spinyin=" + spinyin
				+ ", start=" + start + ", model=" + model + "]";
	}

}
