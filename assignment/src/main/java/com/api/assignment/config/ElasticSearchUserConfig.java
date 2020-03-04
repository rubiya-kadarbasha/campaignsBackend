/**
 * <p>Title       		: ElasticSearchUserConfig </p>
 * <p>Description 		: ElasticSearchUserConfig Class.</p>
 * <p>Date of Creation 	: 2020-02-19</p>
 * <p>Source      		: ElasticSearchUserConfig </p>
 * <p>Package     		: com.api.assignment.config</p>
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

package com.api.assignment.config;



import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.List;


import javax.annotation.PostConstruct;

import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.api.assignment.model.UserEntity;

import io.searchbox.client.JestClient;
import io.searchbox.client.JestClientFactory;
import io.searchbox.client.config.HttpClientConfig;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;


/**
 * The Class ElasticSearchUserConfig.
 *  @author rubiya.kadarbasha
 */
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Component
public class ElasticSearchUserConfig {

	/** The host. */
	@Value("${elasticsearch.host}")
	private String host;

	/** The port. */
	@Value("${elasticsearch.port}")
	private int port;

	/** The url. */
	@Value("${elasticsearch.URL}")
	private String url;

	/** The index name. */
	@Value("${elasticsearch.index.name}")
	private String indexName;

	/** The type name. */
	@Value("${elasticsearch.type.name}")
	private String typeName;


	/** Logger. */
	private static final Logger LOG = LoggerFactory.getLogger(ElasticSearchUserConfig.class);

	/** Elastisearch Jest client. */
	private JestClient jestClient;

	

	/**
	 * Post construct method to initialize Jest client.
	 *
	 * @throws NoSuchAlgorithmException the no such algorithm exception
	 */
	@PostConstruct
	public void init() throws NoSuchAlgorithmException {
		final JestClientFactory factory = new JestClientFactory();
		factory.setHttpClientConfig(new HttpClientConfig.Builder(url).multiThreaded(true).build());
		jestClient = factory.getObject();

		LOG.info("<<<<<< Elasticsearch url {}", url);
		LOG.info("<<<<<< Elasticsearch index {}", indexName);
		LOG.info("<<<<<< Elasticsearch index type {}", typeName);

	}

	
	/**
	 * display the list of record using search builder.
	 *
	 * @return the list
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	
	public List<UserEntity> listOfUsers() throws IOException {
		LOG.info("<<<<<< inside listOfUsers method  <<<<<<");
		SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
		searchSourceBuilder.query(QueryBuilders.matchAllQuery());
		Search search = new Search.Builder(searchSourceBuilder.toString()).addIndex(indexName).addType(typeName)
				.build();
		SearchResult result = jestClient.execute(search);
		@SuppressWarnings("deprecation")
		
		List<UserEntity> listOfUsers = result.getSourceAsObjectList(UserEntity.class);
		return listOfUsers;

	}

	
	/**
	 * List of ongoing users.
	 *
	 * @return the list
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public List<UserEntity> listOfOngoingUsers() throws IOException {
		LOG.info("<<<<<< inside listOfOngoingUsers method  <<<<<<");
		SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
		searchSourceBuilder.query(QueryBuilders.commonTermsQuery("ongoing", true));
		Search search = new Search.Builder(searchSourceBuilder.toString()).addIndex(indexName).addType(typeName)
				.build();
		SearchResult result = jestClient.execute(search);
		@SuppressWarnings("deprecation")
		
		List<UserEntity> listOfUsers = result.getSourceAsObjectList(UserEntity.class);
		return listOfUsers;
	}

	
	/**
	 * List of completed users.
	 *
	 * @return the list
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public List<UserEntity> listOfCompletedUsers() throws IOException {
		LOG.info("<<<<<< inside listOfCompletedUsers method  <<<<<<");
		SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
		searchSourceBuilder.query(QueryBuilders.commonTermsQuery("completed", true));
	
		Search search = new Search.Builder(searchSourceBuilder.toString()).addIndex(indexName).addType(typeName)
				.build();
		SearchResult result = jestClient.execute(search);
		@SuppressWarnings("deprecation")
		
		List<UserEntity> listOfUsers = result.getSourceAsObjectList(UserEntity.class);
		return listOfUsers;
	}

	
	/**
	 * List of historical users.
	 *
	 * @param historical the historical
	 * @return the list
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public List<UserEntity> listOfHistoricalUsers(String historical) throws IOException {
		LOG.info("<<<<<< inside listOfHistoricalUsers method  <<<<<<");
		SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
		searchSourceBuilder.query(QueryBuilders.commonTermsQuery("historical", historical));
	
		Search search = new Search.Builder(searchSourceBuilder.toString()).addIndex(indexName).addType(typeName)
				.build();
		SearchResult result = jestClient.execute(search);
		@SuppressWarnings("deprecation")
		
		List<UserEntity> listOfUsers = result.getSourceAsObjectList(UserEntity.class);
		return listOfUsers;
	}
}