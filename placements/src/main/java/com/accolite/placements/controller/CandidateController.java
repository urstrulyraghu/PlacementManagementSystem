package com.accolite.placements.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.accolite.placements.dao.*;
import com.accolite.placements.models.*;

@RestController
public class CandidateController {
	
		private String candidateName = "-1";
	    
	    @Autowired
	    private CandidateDaoImpl candidateDaoImpl;
	    
	    @Autowired
	    private RegisteredStudentDaoImpl registeredStudentDaoImpl;
		
	    /*** login for a user ***/
	    @RequestMapping(value="/login/candidate", method=RequestMethod.POST)
	    public ResponseEntity loginCandidate(@RequestParam("username") String name, @RequestParam("password") String password) {
	    	Candidate candidate = candidateDaoImpl.getCandidateByName(name);
	    	if(candidate.getPassword().equals(password)) {
	    		this.candidateName = name;
	    		return new ResponseEntity(HttpStatus.OK);
	    	}
	    	else {
	    		return new ResponseEntity(HttpStatus.BAD_REQUEST);
	    	}
	    	
	    }
	    
	    /*** Apply for a company ***/
	    @RequestMapping(value="/apply/{company}", method=RequestMethod.POST)
	    public void applyCompany(@PathVariable("company") String companyName) {
	    	RegStudent regStudent = new RegStudent(candidateName, companyName);
	    	RegisteredStudent registeredStudent = new RegisteredStudent(regStudent);
	        registeredStudentDaoImpl.createRegisteredStudent(registeredStudent);

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

}
