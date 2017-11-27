package com.rest.exceptions;

public class ServiceException {

	private Integer reasonCode;
	private String message;
	private String errorMsg;

	public ServiceException(int reason, String message, String error) {
		this.reasonCode = reason;
		this.message = message;
		this.errorMsg = error;
	}

	public Integer getReasonCode() {
		return reasonCode;
	}

	public void setReasonCode(Integer reasonCode) {
		this.reasonCode = reasonCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

}
