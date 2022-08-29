package com.mle.emp.service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mle.emp.domain.User;
import com.mle.emp.repository.UserRepository;
import com.mle.emp.util.CustomPasswordEncoder;

@Service
public class ForgotService {

	private static final long EXPIRE_TOKEN_AFTER_MINUTES = 30;

	@Autowired
	private CustomPasswordEncoder passwordEncoder;
	@Autowired
	private UserRepository UserRepository;

	public String forgotPassword(String username) {

		Optional<User> userOptional = Optional
				.ofNullable(UserRepository.findByusername(username));

		if (!userOptional.isPresent()) {
			return "Invalid username id.";
		}

		User User = userOptional.get();
		User.setToken(generateToken());
		User.setTokenCreationDate(LocalDateTime.now());

		User = UserRepository.save(User);

		return User.getToken();
	}

	public String resetPassword(String token, String password) {

		Optional<User> userOptional = Optional
				.ofNullable(UserRepository.findByToken(token));

		if (!userOptional.isPresent()) {
			return "Invalid token.";
		}

		LocalDateTime tokenCreationDate = userOptional.get().getTokenCreationDate();

		if (isTokenExpired(tokenCreationDate)) {
			return "Token expired.";

		}

		User User = userOptional.get();

		User.setPassword(passwordEncoder.getPasswordEncoder().encode(password));
		User.setToken(null);
		User.setTokenCreationDate(null);

		UserRepository.save(User);

		return "Your password successfully updated.";
	}

	/**
	 * Generate unique token. You may add multiple parameters to create a strong
	 * token.
	 * 
	 * @return unique token
	 */
	private String generateToken() {
		StringBuilder token = new StringBuilder();

		return token.append(UUID.randomUUID().toString())
				.append(UUID.randomUUID().toString()).toString();
	}

	/**
	 * Check whether the created token expired or not.
	 * 
	 * @param tokenCreationDate
	 * @return true or false
	 */
	private boolean isTokenExpired(final LocalDateTime tokenCreationDate) {

		LocalDateTime now = LocalDateTime.now();
		Duration diff = Duration.between(tokenCreationDate, now);

		return diff.toMinutes() >= EXPIRE_TOKEN_AFTER_MINUTES;
	}

}
