package com.ticket.booking.demo.repo;

import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.util.StringUtils;

public class TheatreRepoCustomImpl implements TheatreRepoCustom {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Object[]> getTheatreList(String cityCode, Date showDate) {
		String cityQuery = "";
		String showDateQuery = "";
		if (StringUtils.hasText(cityCode)) {
			cityQuery = " AND c.code='" + cityCode + "'";
		}

		if (Objects.nonNull(showDate)) {
			showDateQuery = " AND ss.date = '" + showDate + "'";
		}

		Query query = entityManager
				.createNativeQuery("SELECT * FROM city c INNER JOIN theatre t ON c.id = t.city_id " + cityQuery
						+ " INNER JOIN screen s ON t.id=s.theatre_id " + " INNER JOIN shows ss ON s.id=ss.screen_id "
						+ showDateQuery + " INNER JOIN movie m ON m.id=ss.movie_id");
		return query.getResultList();
	}

}
