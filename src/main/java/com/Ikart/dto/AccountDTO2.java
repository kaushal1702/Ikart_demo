package com.Ikart.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class AccountDTO2 {
	
	@NotBlank(message="Name is MUST")
	@Pattern(regexp = "[a-zA-Z\\s]+", message = "name contains invalid characters")
	private String name;
	
	@NotEmpty(message="password is MUST")
	@Pattern(regexp="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$",message= "Password should contain at least an uppercase and a lowercase character, a number , a special character and length between 5 and 20 characters")
	private String password;
	
	public AccountDTO2() {

	}	

	public AccountDTO2(String name, String password) {
		super();
		this.name = name;
		this.password = password;
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
	
	

}
