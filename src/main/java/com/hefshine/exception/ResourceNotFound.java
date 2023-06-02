package com.hefshine.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFound extends RuntimeException{

	private static final int serialVersionUID = 1;
	
	public ResourceNotFound(String mesg){
		super(mesg);
		
	}
}
