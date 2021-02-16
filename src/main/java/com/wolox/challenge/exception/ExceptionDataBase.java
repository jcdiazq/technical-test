package com.wolox.challenge.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.NOT_FOUND)
public class ExceptionDataBase extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7068163265516798989L;

	public ExceptionDataBase(String message) {
		super(message);
	}
}
