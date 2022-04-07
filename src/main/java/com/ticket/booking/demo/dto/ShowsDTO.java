package com.ticket.booking.demo.dto;

import java.sql.Date;
import java.sql.Timestamp;

import lombok.Data;

@Data
public class ShowsDTO {

	Integer id;
	MovieDTO movie;
	Date date;
	Timestamp showTime;

}
