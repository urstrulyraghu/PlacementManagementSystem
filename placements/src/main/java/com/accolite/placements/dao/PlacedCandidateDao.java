package com.accolite.placements.dao;

import java.util.List;

import com.accolite.placements.models.PlacedCandidate;

public interface PlacedCandidateDao {
	
	  	public void createPlacedCandidate(PlacedCandidate placedCandidate);
	    
	  	public PlacedCandidate getPlacedCandidateByCandidateName(String candidateName);
	  	
	  	public PlacedCandidate getPlacedCandidateByCompanyName(String companyName);
	  	
	    public List<PlacedCandidate> getAllPlacedCandidates();
	    
	    public void updatePlacedCandidate(PlacedCandidate placedCandidate);
	    
	    
}
