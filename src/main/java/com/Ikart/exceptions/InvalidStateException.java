package com.Ikart.exceptions;

public class InvalidStateException extends Exception{
	
	private static final long serialVersionUID = 1L;
	
	public InvalidStateException() {
		super();
	}
	
	public InvalidStateException(String errors) {
		super(errors);
	}

}
