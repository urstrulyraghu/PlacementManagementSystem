package com.accolite.placement.modelTests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.accolite.placements.models.LoginCredentials;

public class LoginCredentialsTest {

	@Test
	public void testGetUsername() {
		LoginCredentials loginCredentials = new LoginCredentials("user", "pword");
		assertEquals("user",loginCredentials.getUsername());
	}

	@Test
	public void testSetUsername() {
		LoginCredentials loginCredentials = new LoginCredentials("user", "pword");
		loginCredentials.setUsername("raghu");
		assertEquals("raghu",loginCredentials.getUsername());
	}

	@Test
	public void testGetPassword() {
		LoginCredentials loginCredentials = new LoginCredentials();
		loginCredentials.setPassword("accolite");
		assertEquals("accolite", loginCredentials.getPassword());
	}

	@Test
	public void testSetPassword() {
		LoginCredentials loginCredentials = new LoginCredentials();
		loginCredentials.setPassword("accolite");
		assertEquals("accolite", loginCredentials.getPassword());
	}

}
