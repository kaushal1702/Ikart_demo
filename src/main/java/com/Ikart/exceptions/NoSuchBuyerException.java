package com.Ikart.exceptions;

public class NoSuchBuyerException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	public NoSuchBuyerException() {
		super();
	}
	
	public NoSuchBuyerException(String errors) {
		super(errors);
	}


}
