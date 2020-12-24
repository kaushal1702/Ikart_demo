package com.Ikart.exceptions;

public class BuyerAlreadyExistsException extends Exception{
	
	private static final long serialVersionUID = 1L;
	
	public BuyerAlreadyExistsException() {
		super();
	}
	
	public BuyerAlreadyExistsException(String errors) {
		super(errors);
	}


}
