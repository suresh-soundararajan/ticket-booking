/*
 * Created on 2022-02-23 ( 12:58:50 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.3.0
 */
package com.ticket.booking.demo.entities;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * JPA entity class for "Shows"
 *
 * @author Telosys
 *
 */
@Entity
@Table(name = "shows", catalog = "ticket_booking_system")
public class Shows implements Serializable {

	private static final long serialVersionUID = 1L;

	// --- ENTITY PRIMARY KEY
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false)
	private Integer id;

	// --- ENTITY DATA FIELDS
	@Temporal(TemporalType.DATE)
	@Column(name = "date")
	private Date date;

	@Column(name = "show_time")
	private Timestamp showTime;

	@Column(name = "total_seats")
	private Integer totalSeats;

	// --- ENTITY LINKS ( RELATIONSHIP )
	@ManyToOne
	@JoinColumn(name = "movie_id", referencedColumnName = "id", insertable = false, updatable = false)
	private Movie movie;

	@OneToMany(mappedBy = "shows")
	private List<ShowsSeats> listOfShowsSeats;

	@ManyToOne
	@JoinColumn(name = "screen_id", referencedColumnName = "id", insertable = false, updatable = false)
	private Screen screen;

	@OneToMany(mappedBy = "shows")
	private List<Booking> bookingList;

	/**
	 * Constructor
	 */
	public Shows() {
		super();
	}

	// --- GETTERS & SETTERS FOR FIELDS
	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return this.id;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getDate() {
		return this.date;
	}

	public void setShowTime(Timestamp showTime) {
		this.showTime = showTime;
	}

	public Timestamp getShowTime() {
		return this.showTime;
	}

	public void setTotalSeats(Integer totalSeats) {
		this.totalSeats = totalSeats;
	}

	public Integer getTotalSeats() {
		return this.totalSeats;
	}

	// --- GETTERS FOR LINKS
	public Movie getMovie() {
		return this.movie;
	}

	public List<ShowsSeats> getListOfShowsSeats() {
		return this.listOfShowsSeats;
	}

	public Screen getScreen() {
		return this.screen;
	}

	public List<Booking> getListOfBooking() {
		return this.bookingList;
	}

	// --- toString specific method
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(id);
		sb.append("|");
		sb.append(date);
		sb.append("|");
		sb.append(showTime);
		sb.append("|");
		sb.append(totalSeats);
		return sb.toString();
	}

}
