package com.accolite.placement.modeltests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.accolite.placements.models.LoginCredentials;

public class LoginCredentialsTest {

	static final String USER = "user";
	static final String PWORD = "pword";
	static final String USERNAME = "ra";
	
	@Test
	public void testGetUsername() {
		LoginCredentials loginCredentials = new LoginCredentials("USER", PWORD);
		assertEquals(USER,loginCredentials.getUsername());
	}

	@Test
	public void testSetUsername() {
		LoginCredentials loginCredentials = new LoginCredentials("USER", PWORD);
		loginCredentials.setUsername(USERNAME);
		assertEquals(USERNAME,loginCredentials.getUsername());
	}

	@Test
	public void testGetPassword() {
		LoginCredentials loginCredentials = new LoginCredentials(USER, PWORD);
		assertEquals(PWORD, loginCredentials.getPassword());
	}

	@Test
	public void testSetPassword() {
		LoginCredentials loginCredentials = new LoginCredentials();
		loginCredentials.setPassword("accolite");
		assertEquals("accolite", loginCredentials.getPassword());
	}

}
