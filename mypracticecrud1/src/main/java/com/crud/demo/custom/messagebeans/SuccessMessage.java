package com.crud.demo.custom.messagebeans;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class SuccessMessage {
	private String successmessage;
	private String successcode;
	public SuccessMessage() {
		
	}
	public SuccessMessage(String successmessage, String successcode) {
		super();
		this.successmessage = successmessage;
		this.successcode = successcode;
	}

}
