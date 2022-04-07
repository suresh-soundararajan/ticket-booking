package com.ticket.booking.demo.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.ticket.booking.demo.dto.SearchRequestDTO;
import com.ticket.booking.demo.dto.TheatreDTO;
import com.ticket.booking.demo.entities.Theatre;
import com.ticket.booking.demo.service.SearchService;

@Service
public class SearchServiceImpl implements SearchService {

	@Autowired
	private EntityManager entityManager;

	@Autowired
	private ModelMapper modelMapper;

	@SuppressWarnings("unchecked")
	@Override
	public Set<TheatreDTO> search(SearchRequestDTO searchRequestDTO) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Theatre> query = criteriaBuilder.createQuery(Theatre.class);
		Root<Theatre> theatreRoot = query.from(Theatre.class);

		Join<Object, Object> cityJoin = (Join<Object, Object>) theatreRoot.fetch("city");
		Join<Object, Object> screenListJoin = (Join<Object, Object>) theatreRoot.fetch("screenList");
		Join<Object, Object> showsListJoin = (Join<Object, Object>) screenListJoin.fetch("showsList");
		Join<Object, Object> movieJoin = (Join<Object, Object>) showsListJoin.fetch("movie");

		Predicate cityCodeFilter = null;
		Predicate theatreNameFilter = null;
		Predicate movieFilter = null;
		Predicate showDateFilter = null;
		List<Predicate> finalPredicate = new ArrayList<Predicate>();
		if (Objects.nonNull(searchRequestDTO.getCityCode())) {
			cityCodeFilter = criteriaBuilder.equal(cityJoin.get("code"), searchRequestDTO.getCityCode());
			finalPredicate.add(criteriaBuilder.and(cityCodeFilter));
		}
		if (StringUtils.hasText(searchRequestDTO.getTheatreName())) {
			theatreNameFilter = criteriaBuilder.like(theatreRoot.get("name"),
					"%" + searchRequestDTO.getTheatreName() + "%");
			finalPredicate.add(criteriaBuilder.and(theatreNameFilter));
		}
		if (StringUtils.hasText(searchRequestDTO.getMovieName())) {
			movieFilter = criteriaBuilder.like(movieJoin.get("name"), "%" + searchRequestDTO.getMovieName() + "%");
			finalPredicate.add(criteriaBuilder.and(movieFilter));
		}
		if (Objects.nonNull(searchRequestDTO.getShowDate())) {
			showDateFilter = criteriaBuilder.equal(showsListJoin.get("date"), searchRequestDTO.getShowDate());
			finalPredicate.add(criteriaBuilder.and(showDateFilter));
		}

		Predicate[] predictionArray = finalPredicate.toArray(new Predicate[finalPredicate.size()]);
		Predicate finalPredicates = criteriaBuilder.and(predictionArray);
		query.where(finalPredicates);
		TypedQuery<Theatre> theatreQuery = entityManager.createQuery(query);
		List<Theatre> theatreList = theatreQuery.getResultList();
		return theatreList.stream().map(this::convertToDto).collect(Collectors.toSet());
	}

	private TheatreDTO convertToDto(Theatre theatre) {
		TheatreDTO theatreDTO = modelMapper.map(theatre, TheatreDTO.class);
		return theatreDTO;
	}

}
