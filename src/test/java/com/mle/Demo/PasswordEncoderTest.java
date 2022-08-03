package com.mle.Demo;

import org.junit.jupiter.api.Test;
import org.junit.platform.commons.annotation.Testable;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PasswordEncoderTest {
	@Test
	public void encode_password() {
		PasswordEncoder passwordEncoder= new BCryptPasswordEncoder();
		System.out.println(passwordEncoder.encode("hello"));
	}
}
