package com.accolite.placements.dao;

import java.util.List;

import com.accolite.placements.models.Company;

public interface CompanyDao {

	 	public void createCompany(Company company);
	    
	    public Company getCompanyById(long id);
	    public List<Company> getAllCompanys();
	    
	    public void updateCompany(Company company);
	    
	    public void deleteCompany(long id);
	    
}
