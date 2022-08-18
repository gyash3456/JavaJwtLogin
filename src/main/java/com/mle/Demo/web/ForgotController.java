package com.mle.Demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mle.Demo.service.ForgotService;

@RestController
@RequestMapping("/api/auth")
public class ForgotController {

	@Autowired
	private ForgotService forgotService;

	@PostMapping("/forgot-password")
	public String forgotPassword(@RequestParam String email) {

		String response = forgotService.forgotPassword(email);

		if (!response.startsWith("Invalid")) {
			response = "http://localhost:8080/api/auth/reset-password?token=" + response;
		}
		return response;
	}

	@PutMapping("/reset-password")
	public String resetPassword(@RequestParam String token,
			@RequestParam String password) {

		return forgotService.resetPassword(token, password);
	}
}
