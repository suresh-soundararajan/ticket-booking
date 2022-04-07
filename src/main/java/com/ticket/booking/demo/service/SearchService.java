package com.ticket.booking.demo.service;

import java.util.Set;

import com.ticket.booking.demo.dto.SearchRequestDTO;
import com.ticket.booking.demo.dto.TheatreDTO;

public interface SearchService {

	Set<TheatreDTO> search(SearchRequestDTO searchRequestDTO);

}
