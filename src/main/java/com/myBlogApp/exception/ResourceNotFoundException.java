package com.myBlogApp.exception;

public class ResourceNotFoundException extends RuntimeException {

	String resourceName;
	String feildName;
	long fieldValue;

	public ResourceNotFoundException() {

	}

	public ResourceNotFoundException(String resourceName, String feildName, long fieldValue) {
		super(String.format("%s not found with %s : %s", resourceName, feildName, fieldValue));
		this.resourceName = resourceName;
		this.feildName = feildName;
		this.fieldValue = fieldValue;
	}

	public String getResourceName() {
		return resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	public String getFeildName() {
		return feildName;
	}

	public void setFeildName(String feildName) {
		this.feildName = feildName;
	}

	public long getFieldValue() {
		return fieldValue;
	}

	public void setFieldValue(long fieldValue) {
		this.fieldValue = fieldValue;
	}

}
