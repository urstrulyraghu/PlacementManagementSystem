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
	    
	    public void createCompany(Company company)
	    {
	        entityManager.persist(company);
	    }

	    public Company getCompanyByName(String name)
	    {
	    	return entityManager.find(Company.class, name);
	    }

	    public List<Company> getAllCompanys()
	    {
	        return entityManager.createQuery("select stu from Company stu").getResultList();
	    }

	    public void updateCompany(Company company)
	    {
	        entityManager.merge(company);
	    }

}
