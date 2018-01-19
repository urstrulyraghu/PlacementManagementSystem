package com.accolite.placements.utilities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class MailUtility {

	@Autowired
	JavaMailSender mailSender;

	@Async("threadPoolTaskExecutor")
	public void sendEmailAsync(String to, String subject, String text) {
		SimpleMailMessage email = new SimpleMailMessage();
		email.setTo(to);
		email.setSubject(subject);
		email.setText(text);
		mailSender.send(email);
	}
}