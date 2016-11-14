package com.office.common.bean;
public class ReturnData {
	private boolean success;
	private String comment;
	public ReturnData(){}

	public boolean isSuccess() {
		return success;
	}
	
	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public String toString() {
		return "ReturnData [success=" + success + ", comment=" + comment + "]";
	}

	public ReturnData(boolean success, String comment) {
		this.success = success;
		this.comment = comment;
	}
	
	
	
	
}