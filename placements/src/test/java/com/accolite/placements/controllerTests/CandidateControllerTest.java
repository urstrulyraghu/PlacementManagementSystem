package com.accolite.placements.controllerTests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;
import com.accolite.placements.dao.CandidateDaoImpl;
import com.accolite.placements.models.Candidate;
import com.google.gson.Gson;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.Arrays;
import java.util.List;

import junit.framework.TestCase;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:./src/main/webapp/WEB-INF/placement-servlet.xml" })
@WebAppConfiguration
public class CandidateControllerTest extends TestCase {

	private MockMvc mockMvc;
	
	@Mock
	private CandidateDaoImpl candidateDaoImplMock;

	@org.junit.Before
	public void setup() {
		candidateDaoImplMock = Mockito.mock(CandidateDaoImpl.class);
	}
	
	public void testLoginCandidate() {
		
	}

	public void testApplyCompany() {

	}

	@Test
	public void testCreateCandidate() {
		Candidate candidate = new Candidate("rdhusdf", "accolite","be",89.0,78.0,67.9,"raghu@gmfgajkil.com");

        when(candidateDaoImplMock.createCandidate(candidate)).thenReturn(true);

        Gson gson = new Gson();
        String candidateJson = gson.toJson(candidate);
        
        try {
			mockMvc.perform(post("/create/candidate").contentType(MediaType.APPLICATION_JSON)
					.content(candidateJson))
			.andExpect(status().isOk());
		} catch (Exception e) {
			e.printStackTrace();
		}


	}

	@Test
	public void testGetCandidateById() throws Exception {
		Candidate candidate = new Candidate("raghu", "accolite","be",89.0,78.0,67.9,"raghu@gmail.com");
		
		when(candidateDaoImplMock.getCandidateByName("raghu")).thenReturn(candidate);
		
		mockMvc.perform(get("/candidate/{name}","raghu"))
					.andExpect(status().isOk())
					.andExpect(content().contentType(MediaType.APPLICATION_JSON))
					.andExpect(jsonPath("$.name", is("raghu")))
					.andExpect(jsonPath("$.password", is("accolite")))
					.andExpect(jsonPath("$.edQual", is("be")))
					.andExpect(jsonPath("$.sscPercentage", is(89.0)));
	}

	@Test
	public void testGetAllCandidates() {
		Candidate candidate = new Candidate("raghu", "accolite","be",89.0,78.0,67.9,"raghu@gmail.com");
		List<Candidate> candidates = Arrays.asList(candidate);
		when(candidateDaoImplMock.getAllCandidates()).thenReturn(candidates);
		
		try {
			mockMvc.perform(get("/candidates"))
						.andExpect(status().isOk())
						.andExpect(content().contentType(MediaType.APPLICATION_JSON))
						.andExpect(jsonPath("$.name", is("raghu")))
						.andExpect(jsonPath("$.password", is("accolite")))
						.andExpect(jsonPath("$.edQual", is("be")))
						.andExpect(jsonPath("$.sscPercentage", is(89.0)));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}	
	}

	@Test
	public void testUpdateCandidate() {
		Candidate candidate = new Candidate("raghu", "accolite","be",89.0,78.0,67.9,"raghu@gmail.com");

        when(candidateDaoImplMock.updateCandidate(candidate)).thenReturn(true);

        Gson gson = new Gson();
        String candidateJson = gson.toJson(candidate);
        
        try {
			mockMvc.perform(put("/update/candidate").contentType(MediaType.APPLICATION_JSON)
					.content(candidateJson))
			.andExpect(status().isOk());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
