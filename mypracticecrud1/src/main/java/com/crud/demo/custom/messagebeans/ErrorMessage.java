package com.crud.demo.custom.messagebeans;


import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class ErrorMessage {

	private String errormessage;
	private String errorcode;
	public ErrorMessage() {
		
	}
	public ErrorMessage(String errormessage, String errorcode) {
		super();
		this.errormessage = errormessage;
		this.errorcode = errorcode;
	}
	
}
