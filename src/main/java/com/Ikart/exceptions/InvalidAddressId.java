package com.Ikart.exceptions;

public class InvalidAddressId extends Exception{
	private static final long serialVersionUID = 1L;
	
	public InvalidAddressId() {
		super();
	}
	
	public InvalidAddressId(String errors) {
		super(errors);
	}

}
