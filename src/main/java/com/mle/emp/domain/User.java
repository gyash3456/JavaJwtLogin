package com.mle.emp.domain;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;



@Entity
@Table(name = "users")
public class User implements UserDetails{
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String username;
	private String password;
	
	private String token;
	@Column(columnDefinition = "TIMESTAMP")
	private LocalDateTime tokenCreationDate;
//	private String email;
//	public String getEmail() {
//		return email;
//	}
//	public void setEmail(String email) {
//		this.email = email;
//	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public LocalDateTime getTokenCreationDate() {
		return tokenCreationDate;
	}
	public void setTokenCreationDate(LocalDateTime tokenCreationDate) {
		this.tokenCreationDate = tokenCreationDate;
	}
	public User(Long id, String username, String password, String token, LocalDateTime tokenCreationDate,
			Employee employee) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.token = token;
		this.tokenCreationDate = tokenCreationDate;
		//this.employee = employee;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
//	@OneToOne
//	private Employee employee;
//	
//	
//	public Employee getEmployee() {
//		return employee;
//	}
//	public void setEmployee(Employee employee) {
//		this.employee = employee;
//	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}


	@Override
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@Override
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}


	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		ArrayList<GrantedAuthority> roles = new ArrayList<>();
		System.out.println(this.username+"+"+username);
		if(this.username.equals("vikas.rawat@mlesystems.com")) {
			roles.add(new Authority("ADMIN"));
//			System.out.println("your are in admin");
		}
		else {
			roles.add(new Authority("USER"));
		}
		return roles;
	}
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}



}
