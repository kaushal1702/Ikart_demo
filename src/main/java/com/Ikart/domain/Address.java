package com.Ikart.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.Ikart.dto.AddressDTO;

@Entity
public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int addressId ;
	private long phoneNo ;
	private String fullAddress;
	private int pin;
	private String city;
	private String state;
	
	private Address() {
		
	}
	

	public Address(long phoneNo, String fullAddress, int pin, String city, String state) {
		super();
		this.phoneNo = phoneNo;
		this.fullAddress = fullAddress;
		this.pin = pin;
		this.city = city;
		this.state = state;
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
	
	public static AddressDTO prepareAddressDTO(Address address) {
		AddressDTO addressDTO = new AddressDTO(address.getAddressId(),address.getPhoneNo(),address.getFullAddress(),address.getPin(),address.getCity(),address.getState());
		
		return addressDTO;
	
	}


}
