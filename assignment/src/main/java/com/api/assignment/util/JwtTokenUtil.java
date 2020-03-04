/**
 *
 * <p>Title       		: JwtTokenUtil</p>
 * <p>Description 		: This is a JwtTokenUtil class</p>
 * <p>Date of Creation 	: 2020-02-19</p>
 * <p>Source      		: JwtTokenUtil </p>
 * <p>Package     		: com.api.assignment.util</p>
 * 
 * @author Rubiya KadarBasha
 * @version 1.0
 * 
 * <p>------------------------------------------------------------------------------------</p>
 * <p>:MODIFICATION HISTORY:</p>
 * <p>------------------------------------------------------------------------------------</p>
 * <p>SERIAL  AUTHOR     DATE            SCF            DESCRIPTION</p>
 * <p>------------------------------------------------------------------------------------</p>
 * 
 * <p>------------------------------------------------------------------------------------</p>
 */
package com.api.assignment.util;



import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Value;

import org.springframework.stereotype.Component;

import com.api.assignment.models.FailureResponse;
import com.api.assignment.models.LoginPayload;
import com.api.assignment.models.SuccessResponse;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;


/**
 * The Class JwtTokenUtil.
 *
 * @author rubiya.kadarbasha
 */
@Component
public class JwtTokenUtil implements Serializable {


	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 9029863792234865280L;

	/** The Constant JWT_TOKEN_VALIDITY. */
	

	public static final long JWT_TOKEN_VALIDITY = 5*60*60;

	/** The secret. */
	@Value("${jwt.secret}")
	private String secret;

	/**
	 * Gets the username from token.
	 *
	 * @param token the token
	 * @return the username from token
	 */
	public String getUsernameFromToken(String token) {
		return getClaimFromToken(token, Claims::getSubject);
	}

	/**
	 * Gets the issued at date from token.
	 *
	 * @param token the token
	 * @return the issued at date from token
	 */
	public Date getIssuedAtDateFromToken(String token) {
		return getClaimFromToken(token, Claims::getIssuedAt);
	}

	/**
	 * Gets the expiration date from token.
	 *
	 * @param token the token
	 * @return the expiration date from token
	 */
	public Date getExpirationDateFromToken(String token) {
		return getClaimFromToken(token, Claims::getExpiration);
	}

	/**
	 * Gets the claim from token.
	 *
	 * @param <T> the generic type
	 * @param token the token
	 * @param claimsResolver the claims resolver
	 * @return the claim from token
	 */
	public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
		final Claims claims = getAllClaimsFromToken(token);
		return claimsResolver.apply(claims);
	}

	/**
	 * Gets the all claims from token.
	 *
	 * @param token the token
	 * @return the all claims from token
	 */
	private Claims getAllClaimsFromToken(String token) {
		return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
	}

	/**
	 * Checks if is token expired.
	 *
	 * @param token the token
	 * @return the boolean
	 */
	private Boolean isTokenExpired(String token) {
		final Date expiration = getExpirationDateFromToken(token);
		return expiration.before(new Date());
	}

	/**
	 * Ignore token expiration.
	 *
	 * @param token the token
	 * @return the boolean
	 */
	private Boolean ignoreTokenExpiration(String token) {
		// here you specify tokens, for that the expiration is ignored
		return false;
	}

	/**
	 * Generate success token.
	 *
	 * @param userDetails the user details
	 * @param response the response
	 * @return the string
	 */
	public String generateSuccessToken(LoginPayload userDetails,SuccessResponse response) {
		Map<String, Object> claims = new HashMap<>();
		claims.put("", response);
		
		return doGenerateToken(claims, userDetails.getUsername());
	}

	/**
	 * Generate failed token.
	 *
	 * @param userDetails the user details
	 * @param response the response
	 * @return the string
	 */
	public String generateFailedToken(LoginPayload userDetails,FailureResponse response) {
		Map<String, Object> claims = new HashMap<>();
		claims.put("", response);
		
		return doGenerateToken(claims, userDetails.getUsername());
	}
	
	/**
	 * Do generate token.
	 *
	 * @param claims the claims
	 * @param subject the subject
	 * @return the string
	 */
	private String doGenerateToken(Map<String, Object> claims, String subject) {

		return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY*1000)).signWith(SignatureAlgorithm.HS512, secret).compact();
	}

	/**
	 * Can token be refreshed.
	 *
	 * @param token the token
	 * @return the boolean
	 */
	public Boolean canTokenBeRefreshed(String token) {
		return (!isTokenExpired(token) || ignoreTokenExpiration(token));
	}

	/**
	 * Validate token.
	 *
	 * @param token the token
	 * @param userDetails the user details
	 * @return the boolean
	 */
	public Boolean validateToken(String token, LoginPayload userDetails) {
		final String username = getUsernameFromToken(token);
		return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
	}

	/**
	 * Generate token.
	 *
	 * @param succ the succ
	 * @return the string
	 */
	public String generateToken(SuccessResponse succ) {
		Map<String, Object> claims = new HashMap<>();
		claims.put("", succ);
		
		return doGenerateToken(claims,"islogout");
	
		
	}
	
	/**
	 * Generate tokens.
	 *
	 * @param failres the failres
	 * @return the string
	 */
	public String generateTokens(FailureResponse failres) {
		Map<String, Object> claims = new HashMap<>();
		claims.put("", failres);
		
		return doGenerateToken(claims,"islogout");
	
		
	}
}
