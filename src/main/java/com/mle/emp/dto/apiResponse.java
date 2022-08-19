package com.mle.emp.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class apiResponse {

	private String message;
	private Boolean success;
//	public apiResponse(String message2, boolean b) {
//		// TODO Auto-generated constructor stub
//	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Boolean getSuccess() {
		return success;
	}
	public void setSuccess(Boolean success) {
		this.success = success;
	}
	
	
}
