package com.accolite.placements.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.accolite.placements.dao.PlacedCandidateDaoImpl;
import com.accolite.placements.models.PlacedCandidate;

@RestController
public class PlacedStudentController {
	@Autowired
    private PlacedCandidateDaoImpl placedCandidatedaoImpl;

	
	/**Create PlacedCandidate ***/
	@RequestMapping(value="/create/placedCandidate",consumes="application/json", produces="application/json",
			method=RequestMethod.POST)
	public void createPlacedCandidate(@RequestBody PlacedCandidate placedCandidate) {
		placedCandidatedaoImpl.createPlacedCandidate(placedCandidate);
	}
	
	/*** Get all Placed Candidates ***/
	@RequestMapping(value="/placedCandidates",produces="application/json",
			method=RequestMethod.GET)
	public List<PlacedCandidate> getAllPlacedCandidates(){
		return placedCandidatedaoImpl.getAllPlacedCandidates();
	}
    
	/*** GetPlaced Candidates by Year ***/
	@RequestMapping(value="/placedCandidates/{year}",produces="application/json",
			method=RequestMethod.GET)
	public List<PlacedCandidate> getPlacedCandidatesByYear(@PathVariable("year") String year){
		return placedCandidatedaoImpl.getPlacedCandidatesByYear(year);
	}
	
	
}
