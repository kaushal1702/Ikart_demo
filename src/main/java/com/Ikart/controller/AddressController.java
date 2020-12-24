package com.Ikart.controller;

import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Ikart.dto.AddressDTO;
import com.Ikart.dto.ErrorMessage;
import com.Ikart.exceptions.InvalidAddressId;
import com.Ikart.exceptions.InvalidStateException;
import com.Ikart.service.AddressService;

@RestController
@RequestMapping("/")
public class AddressController {
	
	@Autowired
	private AddressService addressService ;
	
	@GetMapping(value="/{email}/address/{addressId}",produces = "application/json")
	public AddressDTO displayAddress(@PathVariable("email") String email , @PathVariable("addressId") int addressId) throws InvalidAddressId
	{
		return addressService.viewAddress(email,addressId);

	}
	
	@PostMapping(value="/{email}/address/add",consumes = "application/json")
	public ResponseEntity addAddress(@PathVariable("email") String email , @Valid @RequestBody AddressDTO addressDTO,Errors errors) throws InvalidStateException
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
		response = addressService.createAddress(email,addressDTO);
		return ResponseEntity.ok(response);
		}
		//return "New Address for email "+email+" saved successfully";
	}
	
	@PutMapping(value="/{email}/address/{addressId}/modify",consumes = "application/json")
	public ResponseEntity modifyAddress(@PathVariable("email") String email , @PathVariable("addressId") int addressId,@Valid @RequestBody AddressDTO addressDTO,Errors errors) throws InvalidStateException,InvalidAddressId
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

		response = addressService.updateAddress(email,addressId,addressDTO);
		return ResponseEntity.ok(response);
		}
	
	}
	
	@DeleteMapping(value="/{email}/address/{addressId}/delete")
	public ResponseEntity<String> deleteAddress(@PathVariable("email") String email , @PathVariable("addressId") int addressId) throws InvalidAddressId
	{
		//This method will delete a address 
		String response = addressService.removeAddress(email,addressId);
		return ResponseEntity.ok(response);
	}

}
