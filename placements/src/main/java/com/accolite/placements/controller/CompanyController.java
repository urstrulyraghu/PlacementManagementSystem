package com.accolite.placements.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.accolite.placements.dao.CompanyDaoImpl;
import com.accolite.placements.models.Company;

@RestController
public class CompanyController {

    @Autowired
    private CompanyDaoImpl CompanyDAOImpl;
    
    /*** Creating a new Company ***/
    @RequestMapping(value="/create/company", method=RequestMethod.POST, 
            produces="application/json", consumes="application/json")
    public void createCompany(@RequestBody Company company)
    {
        CompanyDAOImpl.createCompany(company);
    }
    
    /*** Retrieve a single Company ***/
    @RequestMapping(value="/Company/{name}",produces="application/json",
            method=RequestMethod.GET)
    public Company getCompanyByName(@PathVariable("name") String name)
    {
    	System.out.println("******Hello");
        return CompanyDAOImpl.getCompanyByName(name);
    }
    
    /*** Retrieve all Companys ***/
    @RequestMapping(value="/Companys",produces="application/json",
            method=RequestMethod.GET)
    public List<Company> getAllCompanys()
    {
        return CompanyDAOImpl.getAllCompanys();
    }
    
    /*** Update a Company ***/
    @RequestMapping(value="/update/company", method=RequestMethod.PUT, 
            produces="application/json", consumes="application/json")
    public void updateCompany(@RequestBody Company company)
    {
        CompanyDAOImpl.updateCompany(company);
    }
    
    /*** Delete a Company ***/
    @RequestMapping(value="/delete/company/{name}",method = RequestMethod.DELETE,
             produces="application/json")
    public void deleteCompany(@PathVariable("name") String name)
    {
        CompanyDAOImpl.deleteCompany(name);
    }
}
