package com.mle.emp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
@Service
public class EmailSenderService {
     
	@Autowired
	private JavaMailSender mailSender;
	
	public void sendEmail(String toEmail,String subject,String body)
	{
		
//try {
	SimpleMailMessage message=new SimpleMailMessage();
	message.setFrom("no-reply@example.com");
	message.setTo(toEmail);
	message.setSubject(subject);
	message.setText(body);
	
	mailSender.send(message);
	System.out.println("Mail Sent Successfully");
	
//} catch (Exception e) {
//	System.out.println("Mail not Sent ");
//}
//		
	}
}

