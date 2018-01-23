package com.accolite.placements.controllertests;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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

import com.accolite.placements.dao.PlacedCandidateDaoImpl;
import com.accolite.placements.models.PlacedCandidate;
import com.accolite.placements.models.PlacedCandidateId;
import com.google.gson.Gson;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:./src/main/webapp/WEB-INF/placement-servlet.xml" })
@WebAppConfiguration
public class PlacedStudentControllerTest {

	static final String NAME = "accolite";
	static final String YEAR = "2017";
	
	private static final Logger logger = Logger.getLogger(PlacedStudentControllerTest.class);

	private MockMvc mockMvc;

	@Autowired
	private PlacedCandidateDaoImpl placedCandidateDaoImplMock;
	
	@org.junit.Before
	public void setup() {
		placedCandidateDaoImplMock = Mockito.mock(PlacedCandidateDaoImpl.class);
	}
	
	@Test
	public void testCreatePlacedCandidate() {
		
		PlacedCandidate placedCandidate = new PlacedCandidate(new PlacedCandidateId(YEAR, NAME), 45, 9.80);
		when(placedCandidateDaoImplMock.createPlacedCandidate(placedCandidate)).thenReturn(true);

        Gson gson = new Gson();
        String placedCandidateJson = gson.toJson(placedCandidate);
        
        try {
			mockMvc.perform(post("/create/placedCandidate").contentType(MediaType.APPLICATION_JSON)
					.content(placedCandidateJson))
			.andExpect(status().isOk());
		} catch (Exception e) {
			logger.error(e.getMessage());
		}

	}

	@Test
	public void testGetAllPlacedCandidates() {
		
		PlacedCandidate placedCandidate = new PlacedCandidate(new PlacedCandidateId(YEAR, NAME), 45, 9.80);
		List<PlacedCandidate> placedCandidates = Arrays.asList(placedCandidate);
		when(placedCandidateDaoImplMock.getAllPlacedCandidates()).thenReturn(placedCandidates);
		
		try {
			mockMvc.perform(get("/placedCandidates"))
						.andExpect(status().isOk())
						.andExpect(content().contentType(MediaType.APPLICATION_JSON))
						.andExpect(jsonPath("$.candidateCount", is(45)));

		} catch (Exception e) {
			e.getMessage();
		}	
	}

	@Test
	public void testGetPlacedCandidatesByYear() {
		
		PlacedCandidate placedCandidate = new PlacedCandidate(new PlacedCandidateId(YEAR, NAME), 45, 9.80);
		List<PlacedCandidate> placedCandidates = Arrays.asList(placedCandidate);
		when(placedCandidateDaoImplMock.getAllPlacedCandidates()).thenReturn(placedCandidates);
		
		try {
			mockMvc.perform(get("/placedCandidates/{year}",2017))
						.andExpect(status().isOk())
						.andExpect(content().contentType(MediaType.APPLICATION_JSON))
						.andExpect(jsonPath("$.candidateCount", is(45)));

		} catch (Exception e) {
			e.getMessage();
		}	
	}

}
