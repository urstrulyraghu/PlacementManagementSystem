package com.accolite.placements.daoTests;

import java.sql.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import com.accolite.placements.dao.CompanyDaoImpl;
import com.accolite.placements.models.Company;

import junit.framework.TestCase;

public class CompanyDaoImplTest extends TestCase {

	@Autowired
	private CompanyDaoImpl companyDaoImpl;
	
	@SuppressWarnings("deprecation")
	@Test
	@Rollback(true)
	public void testCreateCompany() {
		Company company = new Company("accolite","sde","jdjdj",new Date(2017, 12, 12),9.80);
	}

	@Test
	@Rollback(true)
	public void testGetCompanyByName() {
		fail("Not yet implemented");
	}

	@Test
	@Rollback(true)
	public void testGetAllCompanys() {
		fail("Not yet implemented");
	}

	@Test
	@Rollback(true)
	public void testUpdateCompany() {
		fail("Not yet implemented");
	}
}
