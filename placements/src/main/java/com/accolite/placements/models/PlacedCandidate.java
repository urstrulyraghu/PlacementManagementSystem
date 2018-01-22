package com.accolite.placements.models;

import java.io.Serializable;

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

	int candidateCount;
	double payPackage;
	
	public PlacedCandidateId getPlacedCandidateId() {
		return placedCandidateId;
	}
	public void setPlacedCandidateId(PlacedCandidateId placedCandidateId) {
		this.placedCandidateId = placedCandidateId;
	}
	public int getCandidateCount() {
		return candidateCount;
	}
	public void setCandidateCount(int candidateCount) {
		this.candidateCount = candidateCount;
	}
	public double getPayPackage() {
		return payPackage;
	}
	public void setPayPackage(double payPackage) {
		this.payPackage = payPackage;
	}
	public PlacedCandidate(PlacedCandidateId placedCandidateId, int candidateCount, double payPackage) {
		super();
		this.placedCandidateId = placedCandidateId;
		this.candidateCount = candidateCount;
		this.payPackage = payPackage;
	}
	public PlacedCandidate() {
		super();
	}
	
	
}
