package com.accolite.placement.modeltests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

import com.accolite.placements.models.ChangePassword;

public class ChangePasswordTest {
	
	static final String CURRPWORD = "abcd";
	static final String NEWPWORD = "abcdef";
	static final String SETPWORD = "raghu";
	
	@Test
	public void testGetCurrentPassword() {
		ChangePassword changePassword = new ChangePassword();
		changePassword.setCurrentPassword(CURRPWORD);
		changePassword.setNewPassword(NEWPWORD);
		assertEquals(CURRPWORD, changePassword.getCurrentPassword());
		assertFalse(SETPWORD.equals(changePassword.getCurrentPassword()));
	}

	@Test
	public void testSetCurrentPassword() {
		ChangePassword changePassword = new ChangePassword(CURRPWORD,NEWPWORD);
		changePassword.setCurrentPassword(SETPWORD);
		assertEquals(SETPWORD,changePassword.getCurrentPassword());
	}

	@Test
	public void testGetNewPassword() {
		ChangePassword changePassword = new ChangePassword(CURRPWORD,NEWPWORD);
		assertEquals(NEWPWORD,changePassword.getNewPassword());	
	}

	@Test
	public void testSetNewPassword() {
		ChangePassword changePassword = new ChangePassword(CURRPWORD,NEWPWORD);
		changePassword.setNewPassword(SETPWORD);
		assertEquals(SETPWORD,changePassword.getNewPassword());	
	}

}
