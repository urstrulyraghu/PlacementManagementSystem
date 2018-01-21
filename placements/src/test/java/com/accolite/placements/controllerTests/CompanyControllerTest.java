package com.accolite.placements.controllerTests;

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

	private MockMvc mockMvc;

	@Autowired
	private CompanyDaoImpl companyDaoImplMock;
	
	@org.junit.Before
	public void setup() {
		companyDaoImplMock = Mockito.mock(CompanyDaoImpl.class);
	}
	
	@Test
	public void testCreateCompany() {
		Company company = new Company("accolite","sde","jdjdj",Date.valueOf("2017-09-09"),9.80);
		
		when(companyDaoImplMock.createCompany(company)).thenReturn(true);

        Gson gson = new Gson();
        String companyJson = gson.toJson(company);
        
        try {
			mockMvc.perform(post("/create/company").contentType(MediaType.APPLICATION_JSON)
					.content(companyJson))
			.andExpect(status().isOk());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	public void testGetCompanyByName() throws Exception {
		Company company = new Company("accolite","sde","jdjdj",Date.valueOf("2017-09-09"),9.80);
		
		when(companyDaoImplMock.getCompanyByName("accolite")).thenReturn(company);
		
		mockMvc.perform(get("/company/{name}","raghu"))
					.andExpect(status().isOk())
					.andExpect(content().contentType(MediaType.APPLICATION_JSON))
					.andExpect(jsonPath("$.name", is("accolite")))
					.andExpect(jsonPath("$.jobRole", is("sde")));
	}

	@Test
	public void testGetAllCompanys() {
		Company company = new Company("accolite","sde","jdjdj",Date.valueOf("2017-09-09"),9.80);
		List<Company> companys = Arrays.asList(company);
		when(companyDaoImplMock.getAllCompanys()).thenReturn(companys);
		
		try {
			mockMvc.perform(get("/companys"))
						.andExpect(status().isOk())
						.andExpect(content().contentType(MediaType.APPLICATION_JSON))
						.andExpect(jsonPath("$.name", is("accolite")));

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}	
	}

	@Test
	public void testUpdateCompany() {
		Company company = new Company("accolite","sde","jdjdj",Date.valueOf("2017-09-09"),9.80);

        when(companyDaoImplMock.updateCompany(company)).thenReturn(true);

        Gson gson = new Gson();
        String companyJson = gson.toJson(company);
        
        try {
			mockMvc.perform(put("/update/company").contentType(MediaType.APPLICATION_JSON)
					.content(companyJson))
			.andExpect(status().isOk());
		} catch (Exception e) {
			e.printStackTrace();
		}	}

}
