package com.ticket.booking.demo.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ticket.booking.demo.dto.SearchRequestDTO;
import com.ticket.booking.demo.dto.TheatreDTO;
import com.ticket.booking.demo.service.SearchService;

@RestController
@RequestMapping("/api/v1.0")
public class SearchController {

	@Autowired
	SearchService searchService;

	@PostMapping("/theatre")
	Set<TheatreDTO> search(@RequestBody SearchRequestDTO searchRequestDTO) {
		return searchService.search(searchRequestDTO);
	}

}
