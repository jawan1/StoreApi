package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.demo.exc.NoSuchProductException;
import com.example.demo.exc.NoSuchShopException;
import com.example.demo.model.Message;

@ControllerAdvice
public class ExcController extends ResponseEntityExceptionHandler {

	@ExceptionHandler(NoSuchProductException.class)
	public ResponseEntity<Message> handleNoSuchProductException(NoSuchProductException exc) {
		Message excMessage = new Message(exc.getMessage());
		return new ResponseEntity<Message>(excMessage, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(NoSuchShopException.class)
	public ResponseEntity<Message> handleNoSuchShopException(NoSuchShopException exc) {
		Message excMessage = new Message(exc.getMessage());
		return new ResponseEntity<Message>(excMessage, HttpStatus.NOT_FOUND);
	}
	
}
