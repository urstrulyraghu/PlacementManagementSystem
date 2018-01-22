package com.accolite.placement.modelTests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.accolite.placements.models.ChangePassword;

public class ChangePasswordTest {
	
	@Test
	public void testGetCurrentPassword() {
		ChangePassword changePassword = new ChangePassword();
		changePassword.setCurrentPassword("abcd");
		changePassword.setNewPassword("abcdef");
		assertEquals("abcd", changePassword.getCurrentPassword());
		assertFalse("raghu".equals(changePassword.getCurrentPassword()));
	}

	@Test
	public void testSetCurrentPassword() {
		ChangePassword changePassword = new ChangePassword("abcd","abcdef");
		changePassword.setCurrentPassword("raghu");
		assertEquals("raghu",changePassword.getCurrentPassword());
	}

	@Test
	public void testGetNewPassword() {
		ChangePassword changePassword = new ChangePassword("abcd","abcdef");
		assertEquals("abcdef",changePassword.getNewPassword());	
	}

	@Test
	public void testSetNewPassword() {
		ChangePassword changePassword = new ChangePassword("abcd","abcdef");
		changePassword.setNewPassword("raghu");
		assertEquals("raghu",changePassword.getNewPassword());	
	}

}
