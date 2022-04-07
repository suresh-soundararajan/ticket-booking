package com.ticket.booking.demo.dto;

import java.util.List;

import lombok.Data;

@Data
public class TheatreDTO {
	Integer id;
	String name;
	CityDTO city;
	List<ScreenDTO> screenList;
}
