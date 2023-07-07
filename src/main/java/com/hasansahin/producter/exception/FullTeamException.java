package com.hasansahin.producter.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class FullTeamException extends RuntimeException{
	public FullTeamException(String message){
		super(message);
	}
}
