package com.ticket.booking.demo.repo;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface TheatreRepoCustom {

	List<Object[]> getTheatreList(String cityCode, Date showDate);

}
