package com.accolite.placements.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.accolite.placements.dao.CandidateDaoImpl;
import com.accolite.placements.dao.CompanyDaoImpl;
import com.accolite.placements.models.Candidate;
import com.accolite.placements.models.Company;
import com.accolite.placements.utitlities.Notification;

@RestController
public class CompanyController {

    @Autowired
    private CompanyDaoImpl companyDaoImpl;
    
    @Autowired
    private CandidateDaoImpl candidateDaoImpl;
    
    /*** Creating a new Company ***/
    @RequestMapping(value="/create/company", method=RequestMethod.POST, 
            produces="application/json", consumes="application/json")
    public void createCompany(@RequestBody Company company)
    {
    	List<Candidate> candidates = candidateDaoImpl.getAllCandidates();
    	for(Candidate candidate : candidates) {
    		//Notification notification = new Notification(candidate, company);
    		//notification.sendEmail();
    	}
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
    	if(session.getAttribute("userName")!=null) {
    		return companyDaoImpl.getAllCompanys();
    	}else {
    		return null;
    	}        
    }
    
    /*** Update a Company ***/
    @RequestMapping(value="/update/company", method=RequestMethod.PUT, 
            produces="application/json", consumes="application/json")
    public void updateCompany(@RequestBody Company company)
    {
        companyDaoImpl.updateCompany(company);
    }
    
    /*** Delete a Company ***/
    @RequestMapping(value="/delete/company/{name}",method = RequestMethod.DELETE,
             produces="application/json")
    public void deleteCompany(@PathVariable("name") String name)
    {
        companyDaoImpl.deleteCompany(name);
    }
}
