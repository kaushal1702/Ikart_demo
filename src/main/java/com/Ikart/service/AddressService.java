package com.Ikart.service;

import com.Ikart.dto.AddressDTO;
import com.Ikart.exceptions.InvalidAddressId;
import com.Ikart.exceptions.InvalidStateException;

public interface AddressService {
	
	public String createAddress(String email,AddressDTO addressDTO) throws InvalidStateException;
	public AddressDTO viewAddress(String email , int addressId) throws InvalidAddressId;
	public String updateAddress(String email,int addressId,AddressDTO addressDTO) throws InvalidStateException,InvalidAddressId;
	public String removeAddress(String email,int addressId) throws InvalidAddressId;

}
