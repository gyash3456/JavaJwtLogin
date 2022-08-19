package com.mle.emp.service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mle.emp.domain.ForgotEntity;
import com.mle.emp.repository.ForgotRepository;

@Service
public class ForgotService {

	private static final long EXPIRE_TOKEN_AFTER_MINUTES = 30;

	@Autowired
	private ForgotRepository forgotRepository;

	public String forgotPassword(String email) {

		Optional<ForgotEntity> userOptional = Optional
				.ofNullable(forgotRepository.findByEmail(email));

		if (!userOptional.isPresent()) {
			return "Invalid email id.";
		}

		ForgotEntity forgotEntity = userOptional.get();
		forgotEntity.setToken(generateToken());
		forgotEntity.setTokenCreationDate(LocalDateTime.now());

		forgotEntity = forgotRepository.save(forgotEntity);

		return forgotEntity.getToken();
	}

	public String resetPassword(String token, String password) {

		Optional<ForgotEntity> userOptional = Optional
				.ofNullable(forgotRepository.findByToken(token));

		if (!userOptional.isPresent()) {
			return "Invalid token.";
		}

		LocalDateTime tokenCreationDate = userOptional.get().getTokenCreationDate();

		if (isTokenExpired(tokenCreationDate)) {
			return "Token expired.";

		}

		ForgotEntity forgotEntity = userOptional.get();

		forgotEntity.setPassword(password);
		forgotEntity.setToken(null);
		forgotEntity.setTokenCreationDate(null);

		forgotRepository.save(forgotEntity);

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
