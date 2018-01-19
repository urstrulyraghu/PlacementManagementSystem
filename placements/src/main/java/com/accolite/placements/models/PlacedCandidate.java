package com.accolite.placements.models;

import java.io.Serializable;
import java.sql.Date;


import javax.persistence.EmbeddedId;
import javax.persistence.Entity;


@Entity
public class PlacedCandidate implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	PlacedCandidateId placedCandidateId;

	Date year;
	double payPackage;
	
	public PlacedCandidateId getPlacedCandidateId() {
		return placedCandidateId;
	}
	public void setPlacedCandidateId(PlacedCandidateId placedCandidateId) {
		this.placedCandidateId = placedCandidateId;
	}
	public Date getYear() {
		return year;
	}
	public void setYear(Date year) {
		this.year = year;
	}
	public double getPayPackage() {
		return payPackage;
	}
	public void setPayPackage(double payPackage) {
		this.payPackage = payPackage;
	}
	public PlacedCandidate(PlacedCandidateId placedCandidateId, Date year, double payPackage) {
		super();
		this.placedCandidateId = placedCandidateId;
		this.year = year;
		this.payPackage = payPackage;
	}
	public PlacedCandidate() {
		super();
	}
	
	
}
