package com.mle.emp.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.mle.emp.dto.apiResponse;

@RestControllerAdvice
public class GobalExceptionHandler {
     @ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<apiResponse> resourceNotEntityFoundExceptionHandler(ResourceNotFoundException ex){
		String message=ex.getMessage();
//		System.out.println("in global exception");
		apiResponse apiResponse1=new apiResponse(message,false);
		return new ResponseEntity<apiResponse>(apiResponse1,HttpStatus.NOT_FOUND);
	}
	
	 @ExceptionHandler(ResourceAlreadyPresentException.class)
		public ResponseEntity<apiResponse> resourceAlreadyFoundExceptionHandler(ResourceAlreadyPresentException ex){
			String message=ex.getMessage();
			apiResponse apiResponse1=new apiResponse(message,false);
			return new ResponseEntity<apiResponse>(apiResponse1,HttpStatus.NOT_FOUND);
		}
		
	
}
