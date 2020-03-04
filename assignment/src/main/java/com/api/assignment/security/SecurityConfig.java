/**
 *
 * <p>Title       		: SecurityConfig</p>
 * <p>Description 		: This is a SecurityConfig class </p>
 * <p>Date of Creation 	: 2020-02-19</p>
 * <p>Source      		: SecurityConfig </p>
 * <p>Package     		: com.api.assignment.security</p>
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


package com.api.assignment.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.web.bind.annotation.CrossOrigin;


/**
 * The Class SecurityConfig.
 * @author rubiya.KadarBasha
 */
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    /* 
     * @see org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter#configure(org.springframework.security.config.annotation.web.builders.HttpSecurity)
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable()
                .authorizeRequests().antMatchers("**/rubiya/**").authenticated()
                 .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
       
      
        http.headers().cacheControl();

    }
}
