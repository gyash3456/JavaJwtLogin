package com.mle.Demo.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ResourceNotFoundException extends RuntimeException {

	
	private static final long serialVersionUID = 1L;
	String resourceName;
	String fieldName;
	
	Integer fieldValue;

	public ResourceNotFoundException(String resourceName, String fieldName, Integer fieldValue) {
//		super("hi");
		super(String.format("%s not found with %s :%d",resourceName,fieldName,fieldValue));
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
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

	public Integer getFieldValue() {
		return fieldValue;
	}

	public void setFieldValue(Integer fieldValue) {
		this.fieldValue = fieldValue;
	}
	
	
}
