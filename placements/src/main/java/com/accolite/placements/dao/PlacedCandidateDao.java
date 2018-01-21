package com.accolite.placements.dao;

import java.util.List;

import com.accolite.placements.models.PlacedCandidate;

public interface PlacedCandidateDao {
	
	  	public boolean createPlacedCandidate(PlacedCandidate placedCandidate);
	    	  	
	  	public List<PlacedCandidate> getPlacedCandidatesByCompanyName(String companyName);
	  	
	    public List<PlacedCandidate> getAllPlacedCandidates();
	    	   
	    public List<PlacedCandidate> getPlacedCandidatesByYear(String year);
}
