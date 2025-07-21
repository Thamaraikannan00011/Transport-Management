package com.transport.exception;

public class NoRecordFoundException extends RuntimeException{
	private static final long serialVersionUID = 5041703239485814639L;

	public NoRecordFoundException(String message) {
		super(message);
	}
}
