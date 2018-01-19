package com.accolite.placements.daoTests;

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

	@Autowired
	private CompanyDaoImpl companyDaoImpl;
	
	@Test
	@Rollback(true)
	public void testCreateCompany() {
		Company company = new Company("accolite","sde","jdjdj",Date.valueOf("2017-09-09"),9.80);
		boolean result = companyDaoImpl.createCompany(company);
		assertTrue(result);
	}

	
	@Test
	@Rollback(true)
	public void testGetCompanyByName() {
		Company company = new Company("accolite","sde","jdjdj",Date.valueOf("2017-09-09"),9.80);
		companyDaoImpl.createCompany(company);
		Company company1 = companyDaoImpl.getCompanyByName("accolite");
		assertEquals("sde", company1.getJobRole());
	}

	@Test
	@Rollback(true)
	public void testGetAllCompanys() {
		Company company = new Company("accolite","sde","jdjdj",Date.valueOf("2017-09-09"),9.80);
		companyDaoImpl.createCompany(company);
		List<Company> companies = companyDaoImpl.getAllCompanys();
		assertEquals(company, companies.get(0));
	}

	@Test
	@Rollback(true)
	public void testUpdateCompany() {
		Company company = new Company("accolite","sde","jdjdj",Date.valueOf("2017-09-09"),9.80);
		companyDaoImpl.createCompany(company);
		Company company1 = new Company("accolite","sde1","jdjdj",Date.valueOf("2017-09-09"),9.80);
		boolean result = companyDaoImpl.updateCompany(company1);
		assertTrue(result);
	}
}
