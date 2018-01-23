package com.accolite.placements.controllertests;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.sql.Date;
import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import com.accolite.placements.dao.CompanyDaoImpl;
import com.accolite.placements.models.Company;
import com.google.gson.Gson;

import junit.framework.TestCase;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:./src/main/webapp/WEB-INF/placement-servlet.xml" })
@WebAppConfiguration
public class CompanyControllerTest extends TestCase {

	static final String NAME = "accolite";
	static final String JOBROLE = "sde";
	static final String DESCRIPTION = "sbc";
	static final String DATE = "2017-09-09";

	private static final Logger logger = Logger.getLogger(CompanyControllerTest.class);

	private MockMvc mockMvc;

	@Autowired
	private CompanyDaoImpl companyDaoImplMock;
	
	@org.junit.Before
	public void setup() {
		companyDaoImplMock = Mockito.mock(CompanyDaoImpl.class);
	}
	
	@Test
	public void testCreateCompany() {
		Company company = new Company(NAME,JOBROLE,DESCRIPTION,Date.valueOf(DATE),9.80);
		
		when(companyDaoImplMock.createCompany(company)).thenReturn(true);

        Gson gson = new Gson();
        String companyJson = gson.toJson(company);
        
        try {
			mockMvc.perform(post("/create/company").contentType(MediaType.APPLICATION_JSON)
					.content(companyJson))
			.andExpect(status().isOk());
		} catch (Exception e) {
			logger.error(e.getMessage());
		}

	}

	@Test
	public void testGetCompanyByName() throws Exception {
		Company company = new Company(NAME,JOBROLE,DESCRIPTION,Date.valueOf(DATE),9.80);
		
		when(companyDaoImplMock.getCompanyByName(NAME)).thenReturn(company);
		
		mockMvc.perform(get("/company/{NAME}","raghu"))
					.andExpect(status().isOk())
					.andExpect(content().contentType(MediaType.APPLICATION_JSON))
					.andExpect(jsonPath("$.NAME", is(NAME)))
					.andExpect(jsonPath("$.JOBROLE", is(JOBROLE)));
	}

	@Test
	public void testGetAllCompanys() {
		Company company = new Company(NAME,JOBROLE,DESCRIPTION,Date.valueOf(DATE),9.80);
		List<Company> companys = Arrays.asList(company);
		when(companyDaoImplMock.getAllCompanys()).thenReturn(companys);
		
		try {
			mockMvc.perform(get("/companys"))
						.andExpect(status().isOk())
						.andExpect(content().contentType(MediaType.APPLICATION_JSON))
						.andExpect(jsonPath("$.NAME", is(NAME)));

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}	
	}

	@Test
	public void testUpdateCompany() {
		Company company = new Company(NAME,JOBROLE,DESCRIPTION,Date.valueOf(DATE),9.80);

        when(companyDaoImplMock.updateCompany(company)).thenReturn(true);

        Gson gson = new Gson();
        String companyJson = gson.toJson(company);
        
        try {
			mockMvc.perform(put("/update/company").contentType(MediaType.APPLICATION_JSON)
					.content(companyJson))
			.andExpect(status().isOk());
		} catch (Exception e) {
			logger.error(e.getMessage());
		}	
    }

}
