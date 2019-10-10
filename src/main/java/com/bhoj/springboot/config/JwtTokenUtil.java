package com.bhoj.springboot.config;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * JwtTokenUtil class
 * 
 * @author Bhoj Sao
 *
 */
@Component
public class JwtTokenUtil implements Serializable {

	private static final long serialVersionUID = 1L;
	public static final long JWT_TOKEN_VALIDITY = 5 * 60 * 60;

	@Value("${jwt.secret}")
	private String secret;

	/**
	 * Method to get Claim From Token
	 * 
	 * @param <T>
	 * @param token
	 * @param claimsResolver
	 * @return
	 */
	public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
		final Claims claims = getAllClaimsFromToken(token);
		return claimsResolver.apply(claims);
	}

	/**
	 * Method for retrieving any information from token we will need the secret key
	 * 
	 * @param token
	 * @return
	 */
	private Claims getAllClaimsFromToken(String token) {

		return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
	}

	/**
	 * Method to retrieve username from jwt token
	 * 
	 * @param token
	 * @return
	 */
	public String getUsernameFromToken(String token) {

		return this.getClaimFromToken(token, Claims::getSubject);
	}

	/**
	 * Method to retrieve expiration date from jwt token
	 * 
	 * @param token
	 * @return
	 */
	public Date getExpirationDateFromToken(String token) {
		return this.getClaimFromToken(token, Claims::getExpiration);
	}

	/**
	 * Check if the token has expired
	 * 
	 * @param token
	 * @return
	 */
	public Boolean isTokenExpired(String token) {
		return this.getExpirationDateFromToken(token).before(new Date());
	}

	/**
	 * Method to Generate Token
	 * 
	 * @param claims
	 * @param subject
	 * @return
	 */
	private String doGenerateToken(Map<String, Object> claims, String subject) {

		return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY * 1000))
				.signWith(SignatureAlgorithm.HS512, secret).compact();

	}

	/**
	 * Method to generate token for user
	 * 
	 * @param userDetails
	 * @return
	 */
	public String generateToken(UserDetails userDetails) {
		Map<String, Object> claims = new HashMap<>();
		return doGenerateToken(claims, userDetails.getUsername());
	}

	/**
	 * Method to Validate Token
	 * 
	 * @param token
	 * @param userDetails
	 * @return
	 */
	public Boolean validateToken(String token, UserDetails userDetails) {
		final String username = getUsernameFromToken(token);
		return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
	}
}
