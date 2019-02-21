package com.example.demo.exc;

public class NoSuchShopException extends RuntimeException {
	
	public NoSuchShopException(String message) {
		super(message);
	}
}
