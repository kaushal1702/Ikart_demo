package com.Ikart.controller;

import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Ikart.dto.ErrorMessage;
import com.Ikart.dto.LoginDTO;
import com.Ikart.service.LoginService;

@RestController
@RequestMapping("/login")
public class LoginController {

	@Autowired
	private LoginService loginService ;
	
	@PostMapping(consumes = "application/json")
	public ResponseEntity loginMethod(@Valid @RequestBody LoginDTO loginDTO,Errors errors)
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
		
		response = "Either or both of the email and password is incorrect";
		
		if(loginService.login(loginDTO)) {
			response = "User with userdID/emailID :"+loginDTO.getEmail()+" login successfully";
			return new ResponseEntity<String>(response,HttpStatus.OK);
		}
		
		return new ResponseEntity<String>(response,HttpStatus.BAD_REQUEST);

		//return ResponseEntity.ok(response);
		
	}

}
