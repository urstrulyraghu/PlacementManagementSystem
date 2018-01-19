package com.accolite.placements.dao;

import java.util.List;

import com.accolite.placements.models.Company;

public interface CompanyDao {

	 	public boolean createCompany(Company company);
	    
	    public Company getCompanyByName(String name);
	    
	    public List<Company> getAllCompanys();
	    
	    public boolean updateCompany(Company company);
	    	    
}
