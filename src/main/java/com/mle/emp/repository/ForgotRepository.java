package com.mle.emp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mle.emp.domain.ForgotEntity;

@Repository
public interface ForgotRepository extends JpaRepository<ForgotEntity, Long> {

	ForgotEntity findByEmail(String email);

	ForgotEntity findByToken(String token);
}
