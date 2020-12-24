package com.Ikart.exceptions;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.Ikart.dto.ErrorMessage;

@RestControllerAdvice
public class ExceptionControllerAdvice {
	
	@ExceptionHandler(Exception.class)
	public String exceptionHandler(Exception ex) {
		return ex.getMessage();
	}
	
	
	@ExceptionHandler(NoSuchBuyerException.class)
	public ResponseEntity<ErrorMessage> exceptionHandler2(NoSuchBuyerException ex) {
		ErrorMessage error = new ErrorMessage();
		error.setErrorCode(HttpStatus.BAD_REQUEST.value());
		error.setMessage(ex.getMessage());
		return new ResponseEntity<>(error, HttpStatus.OK);
	}
	
	@ExceptionHandler(BuyerAlreadyExistsException.class)
	public ResponseEntity<ErrorMessage> exceptionHandler3(BuyerAlreadyExistsException ex) {
		ErrorMessage error = new ErrorMessage();
		error.setErrorCode(HttpStatus.BAD_REQUEST.value());
		error.setMessage(ex.getMessage());
		return new ResponseEntity<>(error, HttpStatus.OK);
	}
	
	@ExceptionHandler(ConfirmPasswordException.class)
	public ResponseEntity<ErrorMessage> exceptionHandler4(ConfirmPasswordException ex) {
		ErrorMessage error = new ErrorMessage();
		error.setErrorCode(HttpStatus.BAD_REQUEST.value());
		error.setMessage(ex.getMessage());
		return new ResponseEntity<>(error, HttpStatus.OK);
	}

	@ExceptionHandler(InvalidStateException.class)
	public ResponseEntity<ErrorMessage> exceptionHandler5(InvalidStateException ex) {
		ErrorMessage error = new ErrorMessage();
		error.setErrorCode(HttpStatus.BAD_REQUEST.value());
		error.setMessage(ex.getMessage());
		return new ResponseEntity<>(error, HttpStatus.OK);
	}
	
	@ExceptionHandler(InvalidAddressId.class)
	public ResponseEntity<ErrorMessage> exceptionHandler5(InvalidAddressId ex) {
		ErrorMessage error = new ErrorMessage();
		error.setErrorCode(HttpStatus.BAD_REQUEST.value());
		error.setMessage(ex.getMessage());
		return new ResponseEntity<>(error, HttpStatus.OK);
	}
	
	
}
