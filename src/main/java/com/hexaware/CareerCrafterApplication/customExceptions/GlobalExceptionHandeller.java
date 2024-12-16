package com.hexaware.CareerCrafterApplication.customExceptions;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandeller extends ResponseEntityExceptionHandler {
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErrorDetails> handelResourceNotFoundException(ResourceNotFoundException r, WebRequest w){
		ErrorDetails e = new ErrorDetails(LocalDateTime.now(), r.getMessage(), w.getDescription(true), "Not Found");
		return new ResponseEntity<ErrorDetails>(e, HttpStatus.NOT_FOUND);
	}
	
    @ExceptionHandler(UsernameAlreadyExistsException.class)
    public ResponseEntity<ErrorDetails> handleUsernameAlreadyExistsException(UsernameAlreadyExistsException ex, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), ex.getMessage(), request.getDescription(false), "Username Already Exists");
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatusCode statuscode,  WebRequest w) {
		Map<String, String> errors = new HashMap<>();
		
		List<ObjectError> errList = ex.getBindingResult().getAllErrors();
		errList.forEach((error)->{
			String fieldName = ((FieldError)error).getField();
			String message  = error.getDefaultMessage();
			errors.put(fieldName, message);
		});
;
		return new ResponseEntity<Object>(errors, HttpStatus.BAD_REQUEST);
	}
}