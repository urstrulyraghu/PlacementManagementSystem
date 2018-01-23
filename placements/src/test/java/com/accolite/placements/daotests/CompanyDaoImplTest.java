package com.accolite.placements.daotests;

import java.sql.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.accolite.placements.dao.CompanyDaoImpl;
import com.accolite.placements.models.Company;

import junit.framework.TestCase;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:./src/main/webapp/WEB-INF/placement-servlet.xml" })
@Transactional
public class CompanyDaoImplTest extends TestCase {

	static final String NAME = "accolite";
	static final String JOBROLE = "sde";
	static final String DESCRIPTION = "sbc";
	static final String DATE = "2017-09-08";
	
	@Autowired
	private CompanyDaoImpl companyDaoImpl;
	
	@Test
	@Rollback(true)
	public void testCreateCompany() {
		Company company = new Company(NAME,JOBROLE,DESCRIPTION,Date.valueOf(DATE),9.80);
		boolean result = companyDaoImpl.createCompany(company);
		assertTrue(result);
	}

	
	@Test
	@Rollback(true)
	public void testGetCompanyByName() {
		Company company = new Company(NAME,JOBROLE,DESCRIPTION,Date.valueOf(DATE),9.80);
		companyDaoImpl.createCompany(company);
		Company company1 = companyDaoImpl.getCompanyByName(NAME);
		assertEquals(JOBROLE, company1.getJobRole());
		assertEquals(NAME, company1.getName());
		assertEquals(DESCRIPTION,company1.getDescription());
		assertEquals(Date.valueOf(DATE),company1.getDate());
		assertEquals(9.80, company1.getPayPackage());
	}

	@Test
	@Rollback(true)
	public void testGetAllCompanys() {
		Company company = new Company();
		company.setName(NAME);
		company.setDate(Date.valueOf(DATE));
		company.setDescription(DESCRIPTION);
		company.setJobRole(JOBROLE);
		company.setPayPackage(9.80);
		
		companyDaoImpl.createCompany(company);
		List<Company> companies = companyDaoImpl.getAllCompanys();
		assertEquals(company, companies.get(0));
	}

	@Test
	@Rollback(true)
	public void testUpdateCompany() {
		Company company = new Company(NAME,JOBROLE,DESCRIPTION,Date.valueOf(DATE),9.80);
		companyDaoImpl.createCompany(company);
		Company company1 = new Company(NAME,"sde1",DESCRIPTION,Date.valueOf(DATE),9.80);
		boolean result = companyDaoImpl.updateCompany(company1);
		assertTrue(result);
	}
}
