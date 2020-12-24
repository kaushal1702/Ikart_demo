package com.Ikart.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.Ikart.domain.Account;



public class AccountDTO {
	
	@NotNull(message="email is MUST")
	@Email(message= "email pattern is INVALID")
	private String email;
	
	@NotBlank(message="Name is MUST")
	@Pattern(regexp = "[a-zA-Z\\s]+", message = "name contains invalid characters")
	private String name;
	
	@NotEmpty(message="password is MUST")
	@Pattern(regexp="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$",message= "Password should contain at least an uppercase and a lowercase character, a number , a special character and length between 5 and 20 characters")
	private String password;
	
	@NotEmpty(message="confirm password is MUST")
	private String confirmPassword;
	
	@NotNull(message="accountType is MUST")
	private String accountType;
	
	private AddressDTO addressDTO;

	public AccountDTO() {
	}

	public AccountDTO(String email, String name, String password, String confirmPassword, String accountType) {
		super();
		this.email = email;
		this.name = name;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.accountType = accountType;
	}
	
	public AccountDTO(String email, String name, String password, String confirmPassword, String accountType,AddressDTO addressDTO) {
		super();
		this.email = email;
		this.name = name;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.accountType = accountType;
		this.addressDTO = addressDTO;
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
	

	public AddressDTO getAddressDTO() {
		return addressDTO;
	}

	public void setAddressDTO(AddressDTO addressDTO) {
		this.addressDTO = addressDTO;
	}

	public static Account prepareAccountEntity(AccountDTO accountDTO) {
		Account accountEntity = new Account(accountDTO.getEmail(),accountDTO.getName(),accountDTO.getPassword(),accountDTO.getConfirmPassword(),accountDTO.getAccountType());
//		accountEntity.setEmail(accountDTO.getEmail());
//		accountEntity.setName(accountDTO.getName());
//		accountEntity.setPassword(accountDTO.getPassword());
//		accountEntity.setConfirmPassword(accountDTO.getConfirmPassword());
//		accountEntity.setAccountType(accountDTO.getAccountType());
		return accountEntity;
		
	}

}
