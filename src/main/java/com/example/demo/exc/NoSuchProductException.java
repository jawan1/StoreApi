package com.example.demo.exc;

public class NoSuchProductException extends RuntimeException {

	public NoSuchProductException (String message) {
		super(message);
	}
}
