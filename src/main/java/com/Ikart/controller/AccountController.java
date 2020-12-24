package com.Ikart.controller;

import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Ikart.dto.AccountDTO;
import com.Ikart.dto.AccountDTO2;
import com.Ikart.dto.ErrorMessage;
import com.Ikart.exceptions.BuyerAlreadyExistsException;
import com.Ikart.exceptions.ConfirmPasswordException;
import com.Ikart.service.AccountService;

@RestController
@RequestMapping("/account")
public class AccountController {
	
	@Autowired
	private AccountService accountService ;
		
	//Adding a new buyer
	@PostMapping(consumes="application/json")
	public ResponseEntity addAccount(@Valid @RequestBody AccountDTO accountDTO , Errors errors) throws BuyerAlreadyExistsException,ConfirmPasswordException
	{
		
		
		String response = "";
		if (errors.hasErrors()) 
		{			
			response  = errors.getAllErrors().stream()
                                             .map(ObjectError::getDefaultMessage)
                                             .collect(Collectors.joining(","));
			ErrorMessage error = new ErrorMessage();
		    error.setErrorCode(HttpStatus.NOT_ACCEPTABLE.value());
		    error.setMessage(response);
		    return ResponseEntity.ok(error);
		}
		else if(!(accountDTO.getPassword().equals(accountDTO.getConfirmPassword()))){
			throw new ConfirmPasswordException(" Password and Confirm Password are not matching");
		}
		 else
		 {
			 response = accountService.createAccount(accountDTO);
			 return ResponseEntity.ok(response);
		 }
		

	}
	
	
	//Updating an existing buyer
	@PutMapping(value = "/{email}/update", consumes = "application/json")
	public ResponseEntity updateAccount(@PathVariable("email") String email, @Valid @RequestBody AccountDTO2 accountDTO2 , Errors errors) 
	{
		
		
		String response = "";
		if (errors.hasErrors()) 
		{			
			response  = errors.getAllErrors().stream()
                                             .map(ObjectError::getDefaultMessage)
                                             .collect(Collectors.joining(","));
			ErrorMessage error = new ErrorMessage();
		    error.setErrorCode(HttpStatus.NOT_ACCEPTABLE.value());
		    error.setMessage(response);
		    return ResponseEntity.ok(error);
		}		
		else {
			response = accountService.updateAcct(email, accountDTO2);
			return ResponseEntity.ok(response);			
		}

	}
	
	

}
