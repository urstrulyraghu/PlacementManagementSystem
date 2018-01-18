package com.accolite.placements.models;

import java.io.Serializable;
import java.sql.Date;
import java.time.Year;

import javax.persistence.Entity;

@Entity
public class PlacedStudent implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	String candidateName;
	String companyName;
	Date year;

}
