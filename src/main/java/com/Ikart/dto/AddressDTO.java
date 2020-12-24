package com.Ikart.dto;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.Ikart.domain.Address;

public class AddressDTO {
	
	private int addressId ;
	
	@Max(value = 9999999999L , message = "phoneNo must have 10 digits only")
	@Min(value = 1000000000L , message = "phoneNo must have 10 digits only")
	private long phoneNo ;
	private String fullAddress;
	
	@Max(value = 999999 , message = "pin must have 6 digits only")
	@Min(value = 100000 , message = "pin must have 6 digits only")
	private int pin;
	
	
	@Pattern(regexp = "[a-zA-Z\\s]+", message = "city contains invalid characters")
	private String city;
	private String state;
	
	public AddressDTO() {
		
	}
	

	public AddressDTO(long phoneNo, String fullAddress, int pin, String city, String state) {
		super();
		this.phoneNo = phoneNo;
		this.fullAddress = fullAddress;
		this.pin = pin;
		this.city = city;
		this.state = state;
	}
	
	public AddressDTO(int addressID,long phoneNo, String fullAddress, int pin, String city, String state) {
		super();
		this.phoneNo = phoneNo;
		this.fullAddress = fullAddress;
		this.pin = pin;
		this.city = city;
		this.state = state;
		this.addressId = addressID ;
	}

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}


	public long getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getFullAddress() {
		return fullAddress;
	}

	public void setFullAddress(String fullAddress) {
		this.fullAddress = fullAddress;
	}

	public int getPin() {
		return pin;
	}

	public void setPin(int pin) {
		this.pin = pin;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	public static Address prepareAddressEntity(AddressDTO addressDTO) {
		Address addressEntity = new Address(addressDTO.getPhoneNo(),addressDTO.getFullAddress(),addressDTO.getPin(),addressDTO.getCity(),addressDTO.getState());
		
		return addressEntity;

	}
}
