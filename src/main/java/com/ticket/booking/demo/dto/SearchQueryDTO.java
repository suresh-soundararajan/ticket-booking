package com.ticket.booking.demo.dto;

import lombok.Data;

@Data
public class SearchQueryDTO {

	String fieldName;
	String value;
	String operation;

}
