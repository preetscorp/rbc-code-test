package com.rbc.stock.model;

import org.springframework.http.HttpStatus;

public class UploadResponse {

	private String fileName;
	private HttpStatus statusCode;
	private String errorMsg;
	
	
	public UploadResponse(String fileName, HttpStatus statusCode, String errorMsg) {
		super();
		this.fileName = fileName;
		this.statusCode = statusCode;
		this.errorMsg = errorMsg;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public HttpStatus getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(HttpStatus statusCode) {
		this.statusCode = statusCode;
	}
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	
	

}
