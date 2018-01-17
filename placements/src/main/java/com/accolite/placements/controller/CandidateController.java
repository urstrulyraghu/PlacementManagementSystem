package com.accolite.placements.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.accolite.placements.dao.CandidateDaoImpl;
import com.accolite.placements.models.Candidate;

@RestController
public class CandidateController {
	

	    @Autowired
	    private CandidateDaoImpl candidateDaoImpl;
	    
	    /*** login for a user ***/
	    @RequestMapping(value="/login/candidate", method=RequestMethod.POST)
	    public ResponseEntity loginCandidate(@RequestParam("username") String name, @RequestParam("password") String password) {
	    	HttpServletResponse response;
	    	Candidate candidate = candidateDaoImpl.getCandidateByName(name);
	    	if(candidate.getPassword().equals(password)) {
	    		response.setStatus(200);
	    	}
	    	else {
	    		response.setStatus(400);
	    	}
	    	return response;
	    }
	    
	    /*** Creating a new Candidate ***/
	    @RequestMapping(value="/create/candidate", method=RequestMethod.POST, 
	            produces="application/json", consumes="application/json")
	    public void createCandidate(@RequestBody Candidate candidate)
	    {
	        candidateDaoImpl.createCandidate(candidate);
	    }
	    
	    /*** Retrieve a single Candidate ***/
	    @RequestMapping(value="/candidate/{name}", produces="application/json",
	            method=RequestMethod.GET)
	    public Candidate getCandidateById(@PathVariable("name") String name){
	        return candidateDaoImpl.getCandidateByName(name);
	    }
	    
	    /*** Retrieve all Candidates ***/
	    @RequestMapping(value="/candidates", produces="application/json",
	            method=RequestMethod.GET)
	    public List<Candidate> getAllCandidates()
	    {
	        return candidateDaoImpl.getAllCandidates();
	    }
	    
	    /*** Update a Candidate ***/
	    @RequestMapping(value="/update/candidate", method=RequestMethod.PUT, 
	            produces="application/json", consumes="application/json")
	    public void updateCandidate(@RequestBody Candidate candidate)
	    {
	        candidateDaoImpl.updateCandidate(candidate);
	    }
	    
	    /*** Delete a Candidate ***/
	    @RequestMapping(value="/delete/candidate/{id}",method = RequestMethod.DELETE,
	             produces="application/json")
	    public void deleteCandidate(@PathVariable("id") long id)
	    {
	        candidateDaoImpl.deleteCandidate(id);
	    }
}
