package com.parking.api.exception;

public class RepeatedReadException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public RepeatedReadException(String message)
	{
		super(message);
	}
}
