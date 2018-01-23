package com.accolite.placements.controllertests;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import com.accolite.placements.dao.CandidateDaoImpl;
import com.accolite.placements.models.Candidate;
import com.google.gson.Gson;

import junit.framework.TestCase;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:./src/main/webapp/WEB-INF/placement-servlet.xml" })
@WebAppConfiguration
public class CandidateControllerTest extends TestCase {

	private static final Logger logger = Logger.getLogger(CandidateControllerTest.class);

	static final String NAME = "raghu";
	static final String PWORD = "accolite";
	static final String EDQUAL = "Be";
	static final String EMAIL = "raghu@gmail.com";
	
	private MockMvc mockMvc;
	
	@Mock
	private CandidateDaoImpl candidateDaoImplMock;

	@org.junit.Before
	public void setup() {
		candidateDaoImplMock = Mockito.mock(CandidateDaoImpl.class);
	}

	@Test
	public void testCreateCandidate() {
		Candidate candidate = new Candidate(NAME, PWORD,EDQUAL,89.0,78.0,67.9,"NAME@gmfgajkil.com");

        when(candidateDaoImplMock.createCandidate(candidate)).thenReturn(true);

        Gson gson = new Gson();
        String candidateJson = gson.toJson(candidate);
        
        try {
			mockMvc.perform(post("/create/candidate").contentType(MediaType.APPLICATION_JSON)
					.content(candidateJson))
			.andExpect(status().isOk());
		} catch (Exception e) {
			logger.error(e.getMessage());
		}


	}

	@Test
	public void testGetCandidateById() throws Exception {
		Candidate candidate = new Candidate(NAME, PWORD,EDQUAL,89.0,78.0,67.9,EMAIL);
		
		when(candidateDaoImplMock.getCandidateByName(NAME)).thenReturn(candidate);
		
		mockMvc.perform(get("/candidate/{NAME}",NAME))
					.andExpect(status().isOk())
					.andExpect(content().contentType(MediaType.APPLICATION_JSON))
					.andExpect(jsonPath("$.NAME", is(NAME)))
					.andExpect(jsonPath("$.PWORD", is(PWORD)))
					.andExpect(jsonPath("$.EDQUAL", is(EDQUAL)))
					.andExpect(jsonPath("$.sscPercentage", is(89.0)));
	}

	@Test
	public void testGetAllCandidates() {
		Candidate candidate = new Candidate(NAME, PWORD,EDQUAL,89.0,78.0,67.9,EMAIL);
		List<Candidate> candidates = Arrays.asList(candidate);
		when(candidateDaoImplMock.getAllCandidates()).thenReturn(candidates);
		
		try {
			mockMvc.perform(get("/candidates"))
						.andExpect(status().isOk())
						.andExpect(content().contentType(MediaType.APPLICATION_JSON))
						.andExpect(jsonPath("$.NAME", is(NAME)))
						.andExpect(jsonPath("$.PWORD", is(PWORD)))
						.andExpect(jsonPath("$.EDQUAL", is(EDQUAL)))
						.andExpect(jsonPath("$.sscPercentage", is(89.0)));
		} catch (Exception e) {
			e.getMessage();
		}	
	}

	@Test
	public void testUpdateCandidate() {
		Candidate candidate = new Candidate(NAME, PWORD,EDQUAL,89.0,78.0,67.9,EMAIL);

        when(candidateDaoImplMock.updateCandidate(candidate)).thenReturn(true);

        Gson gson = new Gson();
        String candidateJson = gson.toJson(candidate);
        
        try {
			mockMvc.perform(put("/update/candidate").contentType(MediaType.APPLICATION_JSON)
					.content(candidateJson))
			.andExpect(status().isOk());
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}

}
