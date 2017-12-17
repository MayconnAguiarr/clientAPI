package com.api.client.service.exceptions;

public class CityExistingException extends RuntimeException {	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CityExistingException(String message) {
		super(message);
		
	}
	
	public CityExistingException(String message,Throwable cause) {
		super(message,cause);
	}
}
