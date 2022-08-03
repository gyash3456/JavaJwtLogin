package com.mle.Demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.mle.Demo.domain.User;
import com.mle.Demo.repository.UserRepository;
import com.mle.Demo.util.CustomPasswordEncoder;
@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	@Autowired
	private CustomPasswordEncoder passwordEncoder;
	@Autowired
	private UserRepository userRepo;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Optional<User> userOpt=userRepo.findByUsername(username);
//		User user = new User();
//		user.setUsername(username);
//		user.setPassword(passwordEncoder.getPasswordEncoder().encode("hello"));
//		user.setId(1L);
		return userOpt.orElseThrow(()->new UsernameNotFoundException("Invalid credentials"));
	}

}
