/*
 * Created on 2022-02-23 ( 12:58:50 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.3.0
 */
package com.ticket.booking.demo.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

/**
 * JPA entity class for "State"
 *
 * @author Telosys
 *
 */
@Entity
@Table(name="state", catalog="ticket_booking_system" )
public class State implements Serializable {

    private static final long serialVersionUID = 1L;

    //--- ENTITY PRIMARY KEY 
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id", nullable=false)
    private Integer    id ;

    //--- ENTITY DATA FIELDS 
    @Column(name="country_id")
    private Integer    countryId ;

    @Column(name="name", length=200)
    private String     name ;

    @Column(name="code", length=200)
    private String     code ;


    //--- ENTITY LINKS ( RELATIONSHIP )
    @ManyToOne
    @JoinColumn(name="country_id", referencedColumnName="id", insertable=false, updatable=false)
    private Country    country ; 

    @OneToMany(mappedBy="state")
    private List<City> listOfCity ; 


    /**
     * Constructor
     */
    public State() {
		super();
    }
    
    //--- GETTERS & SETTERS FOR FIELDS
    public void setId( Integer id ) {
        this.id = id ;
    }
    public Integer getId() {
        return this.id;
    }

    public void setCountryId( Integer countryId ) {
        this.countryId = countryId ;
    }
    public Integer getCountryId() {
        return this.countryId;
    }

    public void setName( String name ) {
        this.name = name ;
    }
    public String getName() {
        return this.name;
    }

    public void setCode( String code ) {
        this.code = code ;
    }
    public String getCode() {
        return this.code;
    }

    //--- GETTERS FOR LINKS
    public Country getCountry() {
        return this.country;
    } 

    public List<City> getListOfCity() {
        return this.listOfCity;
    } 

    //--- toString specific method
	@Override
    public String toString() { 
        StringBuilder sb = new StringBuilder(); 
        sb.append(id);
        sb.append("|");
        sb.append(countryId);
        sb.append("|");
        sb.append(name);
        sb.append("|");
        sb.append(code);
        return sb.toString(); 
    } 

}