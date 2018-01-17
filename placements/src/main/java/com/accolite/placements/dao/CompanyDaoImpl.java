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
	    
	    public void createCompany(Company Company)
	    {
	        entityManager.persist(Company);
	    }

	    public Company getCompanyByName(String name)
	    {
	    	return (Company)entityManager.createQuery("Select * from Company where name = " + name).getSingleResult();
	    }

	    public List<Company> getAllCompanys()
	    {
	        return entityManager.createQuery("select stu from Company stu").getResultList();
	    }

	    public void updateCompany(Company Company)
	    {
	        entityManager.merge(Company);
	    }

	    public void deleteCompany(String name)
	    {
	        Company s = entityManager.find(Company.class,name);
	        entityManager.remove(s);
	    }
}