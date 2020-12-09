package com.spring.ovs.exceptions;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler 
{
	@ExceptionHandler(ElectionOfficerNotFoundException.class)
	public ResponseEntity<?> UserNotFoundHandling(ElectionOfficerNotFoundException exception)
	{
		ErrorDetails errormessage=new ErrorDetails("OfficerNotFound",exception.getMessage() ,new Date());
		return new ResponseEntity<>(errormessage,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<?> UserNotFoundHandling(UserNotFoundException exception){
		ErrorDetails errormessage=new ErrorDetails("UserNotFound",exception.getMessage() ,new Date());
		return new ResponseEntity<>(errormessage,HttpStatus.NOT_FOUND);
	}
	
		@ExceptionHandler(SocietyNotFoundException.class)
		public ResponseEntity<?> UserNotFoundHandling(SocietyNotFoundException exception){
			ErrorDetails errormessage=new ErrorDetails("SocietyNotFound",exception.getMessage() ,new Date());
			return new ResponseEntity<>(errormessage,HttpStatus.NOT_FOUND);
		}
	
	
	@ExceptionHandler(InvalidOperation.class)
	public ResponseEntity<?> InvalidOperationHandling(InvalidOperation exception){
		ErrorDetails errormessage=new ErrorDetails("InvalidOperation",exception.getMessage(),new Date());
		return new ResponseEntity<>(errormessage,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(VoterNotFoundException.class)
	public ResponseEntity<?> UserNotFoundHandling(VoterNotFoundException exception){
		ErrorDetails errormessage=new ErrorDetails("VoterNotFound",exception.getMessage() ,new Date());
		return new ResponseEntity<>(errormessage,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(NominatedCandidateNotFoundException.class)
	public ResponseEntity<?> UserNotFoundHandling(NominatedCandidateNotFoundException exception){
		ErrorDetails errormessage=new ErrorDetails("CandidateNotFound",exception.getMessage() ,new Date());
		return new ResponseEntity<>(errormessage,HttpStatus.NOT_FOUND);
	}
	
	
	
	
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> CustomValidationErrorHandling(MethodArgumentNotValidException exception)
	{
		ErrorDetails errormessage=new ErrorDetails("Validation Error",exception.getBindingResult().getFieldError().getDefaultMessage() ,new Date());
		return new ResponseEntity<>(errormessage,HttpStatus.BAD_REQUEST);
	}
	
	

}


