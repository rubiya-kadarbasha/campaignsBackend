/**
 *
 * <p>Title       		: AssignmentsController</p>
 * <p>Description 		: This is a controller class which is the entry point for all the requests.</p>
 * <p>Date of Creation 	: 2020-02-19</p>
 * <p>Source      		: AssignmentsController </p>
 * <p>Package     		: com.api.assignment.controller</p>
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

package com.api.assignment.controller;


import java.io.IOException;
import java.util.List;
import java.util.Map;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.assignment.model.SignedResponse;
import com.api.assignment.model.UserEntity;
import com.api.assignment.models.Login;
import com.api.assignment.models.Logout;
import com.api.assignment.service.AssignmentServiceImpl;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.AllArgsConstructor;


/**
 * The Class AssignmentsController.
 *
 * @author rubiya.kadarbasha
 */
@RestController

/**
 * Instantiates a new authentication controller.
 *
 * @param assignmentServiceImpl the authentication service impl
 */
@AllArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
@ComponentScan(basePackages = { "com.api.assignment" })
public class AssignmentsController {

	/**
	 * Logger object is initialized for AssignmentsController class.
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(AssignmentsController.class);

	/** The authentication service impl. */
	@Autowired
	private final AssignmentServiceImpl assignmentServiceImpl;

	/*
	 * This method is the entry point to authentication
	 */
	
	/**
	 * Initiate and validate login transaction.
	 *
	 * @param headersMap the headers map
	 * @param loginObj the login obj
	 * @return the response entity
	 * @throws Exception the exception
	 */
	@PostMapping(value = "/v1/authentication/login", consumes = "application/json")
	public ResponseEntity<SignedResponse> initiateAndValidateLoginTransaction(
			@RequestHeader final Map<String, String> headersMap, @RequestBody final Login loginObj)
			throws Exception {

		
		LOGGER.info(" Request Body --->>> {}", new ObjectMapper().convertValue(loginObj, JsonNode.class).toString());
		ResponseEntity<SignedResponse> htResponseEntity = assignmentServiceImpl.validateJwtAndProcessLoginRequest(headersMap,
				loginObj);
		LOGGER.info("Response -->> {}", htResponseEntity);

		return htResponseEntity;
	}

	/*
	 * This method is the exit point to authentication
	 */
	
	/**
	 * Initiate and validate logout transaction.
	 *
	 * @param headersMap the headers map
	 * @param logoutObj the logout obj
	 * @return the response entity
	 * @throws Exception the exception
	 */
	@PostMapping(value = "/v1/authentication/logout", consumes = "application/json")
	public ResponseEntity<SignedResponse> initiateAndValidateLogoutTransaction(
			@RequestHeader final Map<String, String> headersMap, @RequestBody final Logout logoutObj)
			throws Exception {

		
		LOGGER.info(" Request Body --->>> {}", new ObjectMapper().convertValue(logoutObj, JsonNode.class).toString());
		ResponseEntity<SignedResponse> htResponseEntity = assignmentServiceImpl.validateJwtAndProcessLogoutRequest(headersMap,
				logoutObj);
		LOGGER.info("Response -->> {}", htResponseEntity);

		return htResponseEntity;
	}
	
	
	/*
	 * GET LIST OF USERS
	 */
	
	/**
	 * All users details.
	 *
	 * @return the list
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	@RequestMapping(value = "/campaigns/all", produces = "application/json", method = RequestMethod.GET)
	public @ResponseBody List<UserEntity> allUsersDetails() throws IOException {
		LOGGER.info("<<<<<<<<<<<<<<< AllUsersDetails User Functionality Started <<<<<<<<<<<<");

		
			return assignmentServiceImpl.ListofUsers();
		

	}
	
	/**
	 * All users ongoing details.
	 *
	 * @return the list
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	/*
	 * GET LIST OF ONGOING USERS
	 */
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@RequestMapping(value = "/campaigns/ongoing", produces = "application/json", method = RequestMethod.GET)
	public @ResponseBody List<UserEntity> allUsersOngoingDetails() throws IOException {
		LOGGER.info("<<<<<<<<<<<<<<< AllUsersDetails User Functionality Started <<<<<<<<<<<<");

		
			return assignmentServiceImpl.ListofOngoingUsers();
		

	}
	
	/**
	 * All users completed details.
	 *
	 * @return the list
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	/*
	 * GET LIST OF COMPLETED USERS
	 */
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@RequestMapping(value = "/campaigns/completed", produces = "application/json", method = RequestMethod.GET)
	public @ResponseBody List<UserEntity> allUsersCompletedDetails() throws IOException {
		LOGGER.info("<<<<<<<<<<<<<<< AllUsersDetails User Functionality Started <<<<<<<<<<<<");

		
			return assignmentServiceImpl.ListofcompletedUsers();
		

	}
	
	
	/*
	 * GET LIST OF COMPLETED USERS
	 */

	/**
	 * All users historical details.
	 *
	 * @param historical the historical
	 * @return the list
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	@RequestMapping(value = "/campaigns/historical", produces = "application/json", method = RequestMethod.GET)
	public @ResponseBody List<UserEntity> allUsersHistoricalDetails(@RequestParam String historical) throws IOException {
		LOGGER.info("<<<<<<<<<<<<<<< AllUsersDetails User Functionality Started <<<<<<<<<<<<");

		
			return assignmentServiceImpl.ListofHistoricalUsers(historical);
		

	}
}
