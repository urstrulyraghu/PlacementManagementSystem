package com.accolite.placements.models;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class PlacedCandidateId implements Serializable{
		
	
	String candidateName;
	String companyName;
	public String getCandidateName() {
		return candidateName;
	}
	public void setCandidateName(String candidateName) {
		this.candidateName = candidateName;
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
		result = prime * result + ((candidateName == null) ? 0 : candidateName.hashCode());
		result = prime * result + ((companyName == null) ? 0 : companyName.hashCode());
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
		if (candidateName == null) {
			if (other.getCandidateName() != null)
				return false;
		} else if (!candidateName.equals(other.getCandidateName()))
			return false;
		if (companyName == null) {
			if (other.getCompanyName() != null)
				return false;
		} else if (!companyName.equals(other.getCompanyName()))
			return false;
		return true;
	}
	public PlacedCandidateId(String candidateName, String companyName) {
		super();
		this.candidateName = candidateName;
		this.companyName = companyName;
	}
	public PlacedCandidateId() {
		super();
	}
	
	
}
