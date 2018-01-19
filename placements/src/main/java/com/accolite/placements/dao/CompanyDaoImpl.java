package com.accolite.placements.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.accolite.placements.models.Company;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class CompanyDaoImpl implements CompanyDao{
	
	 	@PersistenceContext
	    private EntityManager entityManager;
	    
	    public boolean createCompany(Company company)
	    {
	    	try {
	    		entityManager.persist(company);
	    		return true;
	    	}
	    	catch(Exception e) {
	    		return false;
	    	}
	    }
	    
	    public Company getCompanyByName(String name)
	    {
	    	return entityManager.find(Company.class, name);
	    }

	    public List<Company> getAllCompanys()
	    {
	        return entityManager.createQuery("select stu from Company stu").getResultList();
	    }

	    public boolean updateCompany(Company company)
	    {
	    	try {
	    		entityManager.merge(company);
	    		return true;
	    	}
	    	catch(Exception e) {
	    		return false;
	    	}
	    }

}
