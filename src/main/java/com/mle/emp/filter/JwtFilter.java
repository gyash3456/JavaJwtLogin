package com.mle.emp.filter;

import java.io.IOException;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import com.mle.emp.repository.UserRepository;
import com.mle.emp.util.JwtUtil;

@Component
public class JwtFilter extends OncePerRequestFilter {
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private JwtUtil jwtUtil;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		final String header = request.getHeader(HttpHeaders.AUTHORIZATION);
        if (!StringUtils.hasText(header) ||(StringUtils.hasText(header)&& !header.startsWith("Bearer "))) {
            chain.doFilter(request, response);
            return;
        }
        final String token = header.split(" ")[1].trim();
        //split by space get index 1 and trim for leading and trading spaces
        
        // Get user identity and set it on the spring security context or else return null
        UserDetails userDetails = userRepo
            .findByUsername(jwtUtil.getUsernameFromToken(token))
            .orElse(null);

        // Get jwt token and validate check expiry and validate username from token and username
        //from userservicedetails object.
        if (!jwtUtil.validateToken(token, userDetails)) {
            chain.doFilter(request, response);
            return;
        }



        UsernamePasswordAuthenticationToken
            authentication = new UsernamePasswordAuthenticationToken(
                userDetails, null,
                userDetails == null ?
                    List.of() : userDetails.getAuthorities()
            );

        authentication.setDetails(
            new WebAuthenticationDetailsSource().buildDetails(request)
        );
//this is where the authentication happens and user get into our application 
        SecurityContextHolder.getContext().setAuthentication(authentication);
        chain.doFilter(request, response);
    }
		
	}

