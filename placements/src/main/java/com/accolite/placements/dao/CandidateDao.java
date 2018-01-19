package com.accolite.placements.dao;

import java.util.List;

import com.accolite.placements.models.Candidate;

public interface CandidateDao {

	    public void createCandidate(Candidate candidate);
	    
	    public Candidate getCandidateByName(String name);
	    
	    public List<Candidate> getAllCandidates();
	    
	    public void updateCandidate(Candidate candidate);
	    
}
