package com.task.retailerrewards.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class RewardsGenericExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<String> handleNotFountExceptions(Exception ex, WebRequest request) {

		StringBuilder response = new StringBuilder("Please contact admin if error persist. \n").append(ex.getMessage());

		return new ResponseEntity<String>(response.toString(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
