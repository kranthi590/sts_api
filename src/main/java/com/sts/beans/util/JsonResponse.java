package com.sts.beans.util;

import java.io.IOException;

import org.codehaus.jackson.map.ObjectMapper;

public class JsonResponse<T> {

	ObjectMapper mapper = new ObjectMapper();

	private String status;
	private String message;
	private T data;

	public JsonResponse(String status, String message, T data) {
		this.status = status;
		this.message = message;
		this.data = data;
	}

	public String getStatus() {
		return status;
	}

	public String getMessage() {
		return message;
	}

	public T getData() {
		return data;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setData(T data) {
		this.data = data;
	}

	public String convertToJSON() {

		String send = null;
		try {
			send = mapper.writeValueAsString(this);
		} catch (IOException e) {
			e.printStackTrace();
			System.err.println("Exception: " + e.getMessage());
		}
		return send;
	}
}
