package com.sode.services.exception;

public class DataIntegrityViolationException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public DataIntegrityViolationException(String message) {
		super(message);
	}
	
}
