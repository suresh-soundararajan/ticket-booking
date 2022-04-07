package com.ticket.booking.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ticket.booking.demo.entities.Country;

@Repository
public interface CountryRepo extends JpaRepository<Country, Integer> {

}
