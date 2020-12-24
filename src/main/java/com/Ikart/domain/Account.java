package com.Ikart.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Transient;



@Entity
public class Account {
	
	@Id
	private String email;
	private String name;
	private String password;
	@Transient
	private String confirmPassword;
	private String accountType;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "addressId", unique = true)
	private Address address;
	

	private Account() {
	}

	public Account(String email, String name, String password, String confirmPassword, String accountType) {
		super();
		this.email = email;
		this.name = name;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.accountType = accountType;
	}
	
	public Account(String email, String name, String password, String confirmPassword, String accountType,Address address) {
		super();
		this.email = email;
		this.name = name;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.accountType = accountType;
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	

}


