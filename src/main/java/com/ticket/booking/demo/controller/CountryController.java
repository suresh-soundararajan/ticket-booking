package com.ticket.booking.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ticket.booking.demo.dto.CountryDTO;
import com.ticket.booking.demo.service.CountryService;

@RestController
@RequestMapping("/country")
public class CountryController {

	@Autowired
	CountryService countryService;

	@GetMapping(value = "")
	List<CountryDTO> getCountries() {
		return countryService.getCountries();
	}

}
