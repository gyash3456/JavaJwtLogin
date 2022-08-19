package com.mle.emp.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ResourceAlreadyPresentException extends RuntimeException{

	String resourceName;
	String fieldName;
	


	public ResourceAlreadyPresentException(String resourceName, String fieldName) {
		super(String.format("%s already present with %s",resourceName,fieldName));
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		
	}



	public String getResourceName() {
		return resourceName;
	}



	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}



	public String getFieldName() {
		return fieldName;
	}



	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
}
