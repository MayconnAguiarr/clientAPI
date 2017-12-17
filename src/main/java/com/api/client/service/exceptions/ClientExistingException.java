package com.api.client.service.exceptions;

public class ClientExistingException extends RuntimeException {	
	private static final long serialVersionUID = 1L;

	public ClientExistingException(String message){
		super(message);		
	}
	
	public ClientExistingException(String message,Throwable cause){
		super(message,cause);
	}
}
