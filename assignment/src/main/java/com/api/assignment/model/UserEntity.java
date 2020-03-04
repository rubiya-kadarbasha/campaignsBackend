/**
 *
 * <p>Title       		: Authentication</p>
 * <p>Description 		: This is a UserEntity class which is create JWT Response</p>
 * <p>Date of Creation 	: 2020-02-19</p>
 * <p>Source      		: UserEntity </p>
 * <p>Package     		: com.api.assignment.model</p>
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


package com.api.assignment.model;

import java.io.Serializable;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;



/**
 * The Class UserEntity.
 *
 * @author rubiya.kadarbasha
 * UserEntity class: Mapping UI Object To ES Object
 */

/**
 * Instantiates a new user entity.
 *
 * @param id the id
 * @param location the location
 * @param name the name
 * @param purpose the purpose
 * @param campaignsDate the campaigns date
 * @param ongoing the ongoing
 * @param completed the completed
 * @param historical the historical
 * @param duration the duration
 * @param status the status
 * @param availablity the availablity
 * @param image the image
 */
@AllArgsConstructor

/**
 * Sets the image.
 *
 * @param image the new image
 */
@Setter

/**
 * Gets the image.
 *
 * @return the image
 */
@Getter
public class UserEntity implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The id. */
	private String id;
	
	/** The location. */
	private String location;
	
	/** The name. */
	private String name;
	
	/** The purpose. */
	private String purpose;
	
	/** The campaigns date. */
	private String campaignsDate;
	
	/** The ongoing. */
	private String ongoing;
	
	/** The completed. */
	private String completed;
	
	/** The historical. */
	private String historical;
	
	/** The duration. */
	private String duration;
	
	/** The status. */
	private String status;
	
	/** The availablity. */
	private String availablity;
	
	/** The image. */
	private String image;
	

}
