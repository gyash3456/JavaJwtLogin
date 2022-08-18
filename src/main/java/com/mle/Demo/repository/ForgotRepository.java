package com.mle.Demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mle.Demo.domain.ForgotEntity;

@Repository
public interface ForgotRepository extends JpaRepository<ForgotEntity, Long> {

	ForgotEntity findByEmail(String email);

	ForgotEntity findByToken(String token);
}
