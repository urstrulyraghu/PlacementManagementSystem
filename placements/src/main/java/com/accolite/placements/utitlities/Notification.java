package com.accolite.placements.utitlities;

import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.beans.factory.annotation.Autowired;
import com.accolite.placements.models.Candidate;
import com.accolite.placements.models.Company;

public class Notification {
	
	 @Autowired
	 private MailSender mailSender;
	
	Candidate candidate;
	Company company;
	
	public String createMessage() {
		return "Hello, " + candidate.getName() + "\n" + company.getName() + " is conducting placement drive on  " + company.getDate() + " for the role of " + company.getJobRole() + " with the pay package of " + company.getPayPackage();
	}
	

	public void sendEmail() {
		SimpleMailMessage email = new SimpleMailMessage();
		email.setTo(candidate.getEmail());
		email.setSubject("New Company");
		email.setText(createMessage());
		mailSender.send(email);
	}

	public Candidate getCandidate() {
		return candidate;
	}


	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}


	public Company getCompany() {
		return company;
	}


	public void setCompany(Company company) {
		this.company = company;
	}


	public Notification(Candidate candidate, Company company) {
		super();
		this.candidate = candidate;
		this.company = company;
	}
	
	
}
