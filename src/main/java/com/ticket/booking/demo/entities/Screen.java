/*
 * Created on 2022-02-23 ( 12:58:50 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.3.0
 */
package com.ticket.booking.demo.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * JPA entity class for "Screen"
 *
 * @author Telosys
 *
 */
@Entity
@Table(name = "screen", catalog = "ticket_booking_system")
public class Screen implements Serializable {

	private static final long serialVersionUID = 1L;

	// --- ENTITY PRIMARY KEY
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false)
	private Integer id;

	// --- ENTITY DATA FIELDS
	@Column(name = "theatre_id")
	private Integer theatreId;

	@Column(name = "name", length = 200)
	private String name;

	@Column(name = "total_seats")
	private Integer totalSeats;

	@Column(name = "number_of_rows")
	private Integer numberOfRows;

	@Column(name = "seats_per_row")
	private Integer seatsPerRow;

	// --- ENTITY LINKS ( RELATIONSHIP )
	@OneToMany(mappedBy = "screen")
	private List<ScreenSeats> screenSeatsList;

	@OneToMany(mappedBy = "screen")
	private Set<Shows> showsList;

	@ManyToOne
	@JoinColumn(name = "theatre_id", referencedColumnName = "id", insertable = false, updatable = false)
	private Theatre theatre;

	/**
	 * Constructor
	 */
	public Screen() {
		super();
	}

	// --- GETTERS & SETTERS FOR FIELDS
	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return this.id;
	}

	public void setTheatreId(Integer theatreId) {
		this.theatreId = theatreId;
	}

	public Integer getTheatreId() {
		return this.theatreId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void setTotalSeats(Integer totalSeats) {
		this.totalSeats = totalSeats;
	}

	public Integer getTotalSeats() {
		return this.totalSeats;
	}

	public void setNumberOfRows(Integer numberOfRows) {
		this.numberOfRows = numberOfRows;
	}

	public Integer getNumberOfRows() {
		return this.numberOfRows;
	}

	public void setSeatsPerRow(Integer seatsPerRow) {
		this.seatsPerRow = seatsPerRow;
	}

	public Integer getSeatsPerRow() {
		return this.seatsPerRow;
	}

	// --- GETTERS FOR LINKS
	public List<ScreenSeats> getListOfScreenSeats() {
		return this.screenSeatsList;
	}

	public Set<Shows> getListOfShows() {
		return this.showsList;
	}

	public Theatre getTheatre() {
		return this.theatre;
	}

	// --- toString specific method
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(id);
		sb.append("|");
		sb.append(theatreId);
		sb.append("|");
		sb.append(name);
		sb.append("|");
		sb.append(totalSeats);
		sb.append("|");
		sb.append(numberOfRows);
		sb.append("|");
		sb.append(seatsPerRow);
		return sb.toString();
	}

}
