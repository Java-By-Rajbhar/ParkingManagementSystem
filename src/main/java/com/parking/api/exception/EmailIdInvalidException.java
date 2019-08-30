package com.parking.api.exception;

public class EmailIdInvalidException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public EmailIdInvalidException(String message)
	{
		super(message);
	}
}
