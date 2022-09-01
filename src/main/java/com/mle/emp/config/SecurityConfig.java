package com.mle.emp.config;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.filter.ForwardedHeaderFilter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.mle.emp.filter.JwtFilter;
import com.mle.emp.util.CustomPasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	UserDetailsService userDetailsService;
	@Autowired
	CustomPasswordEncoder customPasswordEncoder;
	@Autowired
	JwtFilter jwtFilter;
	@Override @Bean
	public AuthenticationManager authenticationManagerBean() throws Exception{
		return super.authenticationManagerBean();
		
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		auth.userDetailsService(userDetailsService).passwordEncoder(customPasswordEncoder.getPasswordEncoder());
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
//		super.configure(http); used for configuring by default security behaviour
		
		http =http.csrf().disable().cors().disable();//disable high level security
		
		http = http.sessionManagement()
					.sessionCreationPolicy(SessionCreationPolicy.STATELESS)//data not stored anywhere
					.and();
		
		http = http.exceptionHandling().authenticationEntryPoint((request,response,ex)->{
			response.sendError(HttpServletResponse.SC_UNAUTHORIZED,ex.getMessage());
		}).and();
		

		http.authorizeRequests()
			.antMatchers("/api/auth/**").permitAll()
             .antMatchers("/api/employees/**").permitAll()
			.antMatchers("/landingpage/admin/**").permitAll()
			.antMatchers("/v3/api-docs").permitAll()
			.antMatchers("/swagger-ui/**").permitAll()
            .antMatchers("/swagger-resources/**").permitAll()
            .antMatchers("/swagger-ui.html").permitAll()
			.anyRequest()
			.authenticated();
		
		http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
	}
	@Bean
	public PasswordEncoder passwordEncoder() {
		
		return new BCryptPasswordEncoder();
	}
	@Bean
	ForwardedHeaderFilter forwardedHeaderFilter() {
	   return new ForwardedHeaderFilter();
	}

}
