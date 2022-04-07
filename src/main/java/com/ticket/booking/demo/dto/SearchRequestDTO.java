package com.ticket.booking.demo.dto;

import java.util.Date;

import lombok.Data;

@Data
public class SearchRequestDTO {

	int pageNumber;
	int totalPerPage;
	String cityCode;
	String theatreName;
	String movieName;
	Date showDate;

}
