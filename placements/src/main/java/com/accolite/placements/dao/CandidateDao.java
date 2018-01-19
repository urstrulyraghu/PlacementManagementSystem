package com.accolite.placements.dao;

import java.util.List;

import com.accolite.placements.models.Candidate;

public interface CandidateDao {

	    public boolean createCandidate(Candidate candidate);
	    
	    public Candidate getCandidateByName(String name);
	    
	    public List<Candidate> getAllCandidates();
	    
	    public boolean updateCandidate(Candidate candidate);
	    
}
