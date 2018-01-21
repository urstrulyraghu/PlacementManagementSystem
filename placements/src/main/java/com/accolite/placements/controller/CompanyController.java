package com.accolite.placements.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.accolite.placements.dao.CandidateDaoImpl;
import com.accolite.placements.dao.CompanyDaoImpl;
import com.accolite.placements.models.Candidate;
import com.accolite.placements.models.Company;
import com.accolite.placements.utilities.MailUtility;

@RestController
public class CompanyController {

	@Autowired
	public MailUtility mailUtility;
	
    @Autowired
    private CompanyDaoImpl companyDaoImpl;
    
    @Autowired
    private CandidateDaoImpl candidateDaoImpl;
    
    /*** Creating a new Company ***/
    @RequestMapping(value="/create/company", method=RequestMethod.POST, 
            produces="application/json", consumes="application/json")
    public void createCompany(@RequestBody Company company)
    {
    	String msgText = "Hello, \n a new company is conducting placement drive with the following details \n " + company.getName() + "\n" + company.getDescription() + "\n" + company.getJobRole() + "\n" + company.getPayPackage() + "\n Date of interview " + company.getDate();
    	List<Candidate> candidates = candidateDaoImpl.getAllCandidates();
//    	for(Candidate candidate : candidates) {
//    		mailUtility.sendEmailAsync(candidate.getEmail(), "A new Company is interviewing!", msgText);
//    	}
        companyDaoImpl.createCompany(company);
    }
    
    /*** Retrieve a single Company ***/
    @RequestMapping(value="/Company/{name}",produces="application/json",
            method=RequestMethod.GET)
    public Company getCompanyByName(@PathVariable("name") String name)
    {
        return companyDaoImpl.getCompanyByName(name);
    }
    
    /*** Retrieve all Companys ***/
    @RequestMapping(value="/Companys",produces="application/json",
            method=RequestMethod.GET)
    public List<Company> getAllCompanys(HttpSession session)
    {
    	return companyDaoImpl.getAllCompanys();
    }
    
    /*** Update a Company ***/
    @RequestMapping(value="/update/company", method=RequestMethod.PUT, 
            produces="application/json", consumes="application/json")
    public void updateCompany(@RequestBody Company company)
    {
        companyDaoImpl.updateCompany(company);
    }
 
}
