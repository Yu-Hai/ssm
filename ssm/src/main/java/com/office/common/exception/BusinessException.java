package com.office.common.exception;

@SuppressWarnings("serial")
public class BusinessException extends Exception{
//业务异常类
	public BusinessException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BusinessException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public BusinessException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public BusinessException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
