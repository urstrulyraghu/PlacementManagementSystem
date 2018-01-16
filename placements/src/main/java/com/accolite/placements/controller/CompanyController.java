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
    @RequestMapping(value="/create", method=RequestMethod.POST, 
            produces="application/json", consumes="application/json")
    public void createCompany(@RequestBody Company Company)
    {
        CompanyDAOImpl.createCompany(Company);
    }
    
    /*** Retrieve a single Company ***/
    @RequestMapping(value="/Company/{id}",produces="application/json",
            method=RequestMethod.GET)
    public Company getCompanyById(@PathVariable("id") long id)
    {
        Company Company = CompanyDAOImpl.getCompanyById(id);
        return Company;
    }
    
    /*** Retrieve all Companys ***/
    @RequestMapping(value="/Companys",produces="application/json",
            method=RequestMethod.GET)
    public List<Company> getAllCompanys()
    {
        List<Company> CompanyList = CompanyDAOImpl.getAllCompanys();
        return CompanyList;
    }
    
    /*** Update a Company ***/
    @RequestMapping(value="/update", method=RequestMethod.PUT, 
            produces="application/json", consumes="application/json")
    public void updateCompany(@RequestBody Company Company)
    {
        CompanyDAOImpl.updateCompany(Company);
    }
    
    /*** Delete a Company ***/
    @RequestMapping(value="/delete/{id}",method = RequestMethod.DELETE,
             produces="application/json")
    public void deleteCompany(@PathVariable("id") long id)
    {
        CompanyDAOImpl.deleteCompany(id);
    }
}
