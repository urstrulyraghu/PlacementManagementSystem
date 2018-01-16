package com.accolite.placements.dao;

import java.util.List;

public interface CandidateDao {

	    public void createCandidate(Candidate candidate);
	    
	    public Candidate getCandidateById(long id);
	    public List<Candidate> getAllCandidates();
	    
	    public void updateCandidate(Candidate candidate);
	    
	    public void deleteCandidate(long id);
	}
	
}
