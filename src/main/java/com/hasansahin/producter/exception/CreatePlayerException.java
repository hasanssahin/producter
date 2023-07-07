package com.hasansahin.producter.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CreatePlayerException extends RuntimeException{
	public CreatePlayerException(String message) {
		super(message);
	}
}
