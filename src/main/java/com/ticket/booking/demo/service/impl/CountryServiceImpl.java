package com.ticket.booking.demo.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ticket.booking.demo.dto.CountryDTO;
import com.ticket.booking.demo.entities.Country;
import com.ticket.booking.demo.repo.CountryRepo;
import com.ticket.booking.demo.service.CountryService;

@Service
public class CountryServiceImpl implements CountryService {

	@Autowired
	CountryRepo countryRepo;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public List<CountryDTO> getCountries() {
		// TODO Auto-generated method stub
		return countryRepo.findAll().stream().map(this::convertToDto).collect(Collectors.toList());
	}

	private CountryDTO convertToDto(Country country) {
		CountryDTO countryDto = modelMapper.map(country, CountryDTO.class);
		return countryDto;
	}

}
