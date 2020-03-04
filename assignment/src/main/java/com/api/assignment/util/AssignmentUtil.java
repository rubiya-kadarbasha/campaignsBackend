/**
 *
 * <p>Title       		: AssignmentUtil</p>
 * <p>Description 		: This is a AssignmentUtil class</p>
 * <p>Date of Creation 	: 2020-02-19</p>
 * <p>Source      		: AssignmentUtil </p>
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


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.api.assignment.constant.Constant;
import com.api.assignment.model.SignedResponse;
import com.api.assignment.models.FailureResponse;
import com.api.assignment.models.Login;
import com.api.assignment.models.SuccessResponse;
import com.api.assignment.models.ValidationErorrs;

import lombok.AllArgsConstructor;

/**
 * 
 * @author rubiya.kadarbasha
 *
 */
@Component
@CrossOrigin(origins = "*", allowedHeaders = "*")
@AllArgsConstructor
public class AssignmentUtil {

	@Autowired
	private JwtTokenUtil jwtCreate;
	/**
	 * Logger object is initialized for AssignmentUtil class.
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(AssignmentUtil.class);

	

	public ResponseEntity<SignedResponse> processRequest(final String responseCode, final Login Obj)
		 {
		
		FailureResponse failres=new FailureResponse();
		SuccessResponse response = new SuccessResponse();
		if(responseCode.equals(Constant.RESPONSE_CODE_200)) {
			response.setResCode(responseCode);
			response.setResMsg("Login Successfull");
		
			final String token = jwtCreate.generateSuccessToken(Obj.getPayload(),response);

			return ResponseEntity.ok(new SignedResponse(token));
			
		} else {
			
			failres.setResCode(Constant.ERROR_CODE_401);
			failres.setResMsg("Invalid UserName or Password");
			ValidationErorrs valErrorsItem=new ValidationErorrs();
			valErrorsItem.setCode(Constant.ERROR_CODE_401);
			valErrorsItem.setMessage("Invalid Credential");
			valErrorsItem.setField("username or password");
			failres.addValErrorsItem(valErrorsItem);
		
			final String token = jwtCreate.generateFailedToken(Obj.getPayload(),failres);
			
		
			return 	 ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new SignedResponse(token));
			
			}

		

		


		

	}



	public ResponseEntity<SignedResponse> processLogoutRequest(String responseCode) {
		FailureResponse failres=new FailureResponse();
		SuccessResponse response = new SuccessResponse();
		if(responseCode.equals(Constant.RESPONSE_CODE_200)) {
			response.setResCode(responseCode);
			response.setResMsg("Logout Successfull");
		
			final String token = jwtCreate.generateToken(response);

			return ResponseEntity.ok(new SignedResponse(token));
			
		} else {
			
			failres.setResCode(Constant.ERROR_CODE_422);
			failres.setResMsg("Invalid logout values");
			ValidationErorrs valErrorsItem=new ValidationErorrs();
			valErrorsItem.setCode(Constant.ERROR_CODE_422);
			valErrorsItem.setMessage("Invalid logout details");
			valErrorsItem.setField("islogout");
			failres.addValErrorsItem(valErrorsItem);
		
			final String token = jwtCreate.generateTokens(failres);
			
		
			return 	 ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(new SignedResponse(token));
			
			}
	}



}
