package com.Ikart.exceptions;

public class ConfirmPasswordException extends Exception{
	private static final long serialVersionUID = 1L;
	
	public ConfirmPasswordException() {
		super();
	}
	
	public ConfirmPasswordException(String errors) {
		super(errors);
	}


}
