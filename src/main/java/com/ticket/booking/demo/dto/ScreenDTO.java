package com.ticket.booking.demo.dto;

import java.util.List;

import lombok.Data;

@Data
public class ScreenDTO {

	Integer id;
	String name;
	List<ShowsDTO> showsList;

}
