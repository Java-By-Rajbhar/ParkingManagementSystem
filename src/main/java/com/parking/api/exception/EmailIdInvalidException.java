package com.parking.api.exception;

public class EmailIdInvalidException extends RuntimeException{

	/**
	 * @Shashank
	 */
	private static final long serialVersionUID = 1L;
	
	public EmailIdInvalidException(String message)
	{
		super(message);
	}
}
