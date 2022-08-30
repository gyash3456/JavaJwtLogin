package com.mle.emp;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

//import com.EMP.EmailSenderService;
import com.mle.emp.service.EmailSenderService;
import com.mle.emp.web.employeeController;

import springfox.documentation.swagger2.annotations.EnableSwagger2;
import com.mle.emp.service.EmailSenderService;
@SpringBootApplication

public class EmpApplication {
	@Autowired
	private EmailSenderService senderService;
	public static void main(String[] args) {
		
		new File(employeeController.uploadDirectory).mkdir();
		SpringApplication.run(EmpApplication.class, args);
	}
//		@EventListener(ApplicationReadyEvent.class)
//		public void sendEmail() {
////			senderService.sendEmail("geet.saini27pics@gmail.com", "Reset Passwprd", "Body of Message");
//			
//			senderService.sendEmail("hansa.saini@mlesystems.com", "Reset Passwprd", "Body of Message");
//		}
	

}
