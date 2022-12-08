package com.bit.PhoneBookApp.exception;

public class ApiResponse {

	private String massage;
	
	private boolean success;

	public String getMassage() {
		return massage;
	}

	public void setMassage(String massage) {
		this.massage = massage;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public ApiResponse(String massage, boolean success) {
		super();
		this.massage = massage;
		this.success = success;
	}

	public ApiResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}