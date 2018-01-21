package com.accolite.placements.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.accolite.placements.dao.*;
import com.accolite.placements.models.*;
import com.accolite.placements.utilities.MailUtility;

@RestController
public class CandidateController {
	
		private String candidateName = "-1";
	    
		@Autowired
		public MailUtility mailUtility;
		
	    @Autowired
	    private CandidateDaoImpl candidateDaoImpl;

	    /*** login for a user ***/
	    @RequestMapping(value="/login/candidate", method=RequestMethod.POST)
	    public ResponseEntity loginCandidate(@RequestBody LoginCredentials loginCredentials,HttpSession session) {
	    	Candidate candidate = candidateDaoImpl.getCandidateByName(loginCredentials.getUsername());
	    	if(candidate.getPassword().equals(loginCredentials.getPassword())) {
	    		this.candidateName = loginCredentials.getUsername();
	    		session.setAttribute("username", loginCredentials.getUsername());
	    		return new ResponseEntity(HttpStatus.OK);
	    	}
	    	else {
	    		return new ResponseEntity(HttpStatus.BAD_REQUEST);
	    	}
	    	
	    }
	    
//	    @RequestMapping(value="/login/placement", method=RequestMethod.POST)
//	    public ResponseEntity loginPlacement(@RequestBody PlacementOfficer placementOfficer,HttpSession session) {
//	    	if(placementOfficer.getPassword().equals("admin123")) {
//	    		session.setAttribute("username", placementOfficer.getUsername());
//	    		return new ResponseEntity(HttpStatus.OK);
//	    	}
//	    	else {
//	    		return new ResponseEntity(HttpStatus.BAD_REQUEST);
//	    	}
//	    }
	    
	    /*** Apply for a company ***/
	    @RequestMapping(value="/apply/{company}", method=RequestMethod.POST)
	    public void applyCompany(@PathVariable("company") String companyName,HttpSession session) {
	        String msgText = "Hello There! \n you have applied for the company" + companyName ; 
	        String name = (String)session.getAttribute("username");
	        Candidate candidate = candidateDaoImpl.getCandidateByName(name);
    		mailUtility.sendEmailAsync(candidate.getEmail(), "A new Company is interviewing!", msgText);
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
	    public Candidate getCandidateById(@PathVariable("name") String name,HttpSession session){
	    	String sessionName = (String) session.getAttribute("username");
	    	if(sessionName!=null) {
	    		return candidateDaoImpl.getCandidateByName(sessionName);
	    	}else {
	    		return null;
	    	}
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
