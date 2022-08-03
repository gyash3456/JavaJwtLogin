package com.mle.Demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mle.Demo.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User>findByUsername(String username);

}
