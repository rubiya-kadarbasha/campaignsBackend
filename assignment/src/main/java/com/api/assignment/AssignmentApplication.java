/**
 * <p>Title       		: AssignmentApplication </p>
 * <p>Description 		: Main Class.</p>
 * <p>Date of Creation 	: 2020-02-19</p>
 * <p>Source      		: AssignmentApplication </p>
 * <p>Package     		: com.api.assignment</p>
 * 
 * @author rubiya.kadarbasha
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

package com.api.assignment;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.CrossOrigin;




/**
 * The Class AssignmentApplication.
 *
 * @author rubiya.kadarbasha
 */
@EnableDiscoveryClient
@ComponentScan(basePackages = { "com.api.assignment" })
@CrossOrigin(origins = "*", allowedHeaders = "*")
@SpringBootApplication
public class AssignmentApplication {

	
	/** The Constant LOG. */
	private static final Logger LOG = LoggerFactory.getLogger(AssignmentApplication.class);


	/** The context. */
	private static ConfigurableApplicationContext context;


	/**
	 * Gets the context.
	 *
	 * @return the context
	 */
	public final static ConfigurableApplicationContext getContext() {
		return context;
	}


	/**
	 * Sets the context.
	 *
	 * @param context the new context
	 */
	public final void setContext(final ConfigurableApplicationContext context) {
		AssignmentApplication.context = context;
	}


	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(final String[] args){
		new AssignmentApplication().run(args);

	}


	/**
	 * Run.
	 *
	 * @param args the args
	 */
	public void run(final String... args)  {
		
		LOG.info("Starting Rest Authentication Login/Logout API And Campaigns Application");
		context = SpringApplication.run(AssignmentApplication.class, args);
	}


}
