package com.accolite.placements.dao;

import java.util.List;

import com.accolite.placements.models.Company;

public interface CompanyDao {

	 	public void createCompany(Company company);
	    
	    public Company getCompanyByName(String name);
	    public List<Company> getAllCompanys();
	    
	    public void updateCompany(Company company);
	    
	    public void deleteCompany(String name);
	    
}
