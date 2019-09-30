package com.capgemini.model;

import java.util.Arrays;
import java.util.List;

public class ResponseModel {
	 
	private String message;
	private List<?> data;
 
	public ResponseModel() {}
 
    
	public ResponseModel(String message, List<?> data) {
		this.message = message;
		this.data = data;
	}

	public ResponseModel(String message, Object data) {
        this.message = message;
        this.data = Arrays.asList(data);
    }


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public List<?> getData() {
		return data;
	}


	public void setData(List<?> data) {
		this.data = data;
	}
	
}