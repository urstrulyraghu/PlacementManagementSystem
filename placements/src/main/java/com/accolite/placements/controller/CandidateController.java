package com.accolite.placements.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.accolite.placements.dao.CandidateDaoImpl;
import com.accolite.placements.models.Candidate;

@RestController
public class CandidateController {
	

	    @Autowired
	    private CandidateDaoImpl candidateDAOImpl;
	    
	    /*** Creating a new Candidate ***/
	    @RequestMapping(value="/create", method=RequestMethod.POST, 
	            produces="application/json", consumes="application/json")
	    public void createCandidate(@RequestBody Candidate candidate)
	    {
	        candidateDAOImpl.createCandidate(candidate);
	    }
	    
	    /*** Retrieve a single Candidate ***/
	    @RequestMapping(value="/candidate/{id}",produces="application/json",
	            method=RequestMethod.GET)
	    public Candidate getCandidateById(@PathVariable("id") long id)
	    {
	        Candidate candidate = candidateDAOImpl.getCandidateById(id);
	        return candidate;
	    }
	    
	    /*** Retrieve all Candidates ***/
	    @RequestMapping(value="/candidates",produces="application/json",
	            method=RequestMethod.GET)
	    public List<Candidate> getAllCandidates()
	    {
	        List<Candidate> candidateList = candidateDAOImpl.getAllCandidates();
	        return candidateList;
	    }
	    
	    /*** Update a Candidate ***/
	    @RequestMapping(value="/update", method=RequestMethod.PUT, 
	            produces="application/json", consumes="application/json")
	    public void updateCandidate(@RequestBody Candidate candidate)
	    {
	        candidateDAOImpl.updateCandidate(candidate);
	    }
	    
	    /*** Delete a Candidate ***/
	    @RequestMapping(value="/delete/{id}",method = RequestMethod.DELETE,
	             produces="application/json")
	    public void deleteCandidate(@PathVariable("id") long id)
	    {
	        candidateDAOImpl.deleteCandidate(id);
	    }
}
