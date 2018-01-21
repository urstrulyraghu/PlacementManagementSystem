package com.accolite.placements.models;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class PlacedCandidateId implements Serializable{
		
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String year;
	String companyName;
	
	public String getYear() {
		return year;
	}
	public void setYear(String Year) {
		this.year = Year;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((companyName == null) ? 0 : companyName.hashCode());
		result = prime * result + ((year == null) ? 0 : year.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PlacedCandidateId other = (PlacedCandidateId) obj;
		if (companyName == null) {
			if (other.companyName != null)
				return false;
		} else if (!companyName.equals(other.companyName))
			return false;
		if (year == null) {
			if (other.year != null)
				return false;
		} else if (!year.equals(other.year))
			return false;
		return true;
	}
	public PlacedCandidateId(String year, String companyName) {
		super();
		this.year = year;
		this.companyName = companyName;
	}
	public PlacedCandidateId() {
		super();
	}
	
	
}
