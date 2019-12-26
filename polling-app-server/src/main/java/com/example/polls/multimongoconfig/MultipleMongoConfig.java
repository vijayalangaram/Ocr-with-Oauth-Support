package com.example.polls.multimongoconfig;

import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import com.mongodb.MongoClient;


//samran tech PVT LMT  - vijay alangaram


// here this class played major role in this app which held to,
// happended the two different database support in a single time appp to perform a user register and the followed the ocr proces these all peformed after the seucred jwt generations



@Configuration
public class MultipleMongoConfig 
{
	// first db
	@Primary
	@Bean(name = "car_dealer4")
	@ConfigurationProperties(prefix = "spring.data.mongodb")
	public MongoProperties getPrimary() {
	    return new MongoProperties();
	}
	
	//2n db
	@Bean(name = "test-db")
	@ConfigurationProperties(prefix = "mongodb")
	public MongoProperties getSecondary() {
	    return new MongoProperties();
	}
	
	
	//1st bean 
	@Primary
	@Bean(name = "primaryMongoTemplate")
	public MongoTemplate primaryMongoTemplate() throws Exception {
	    return new MongoTemplate(primaryFactory(getPrimary()));
	}
	
	//2nd bean 
	@Bean(name = "secondaryMongoTemplate")
	public MongoTemplate secondaryMongoTemplate() throws Exception {
	    return new MongoTemplate(secondaryFactory(getSecondary()));
	}
	
	
	
	@Bean
	@Primary
	public MongoDbFactory primaryFactory(final MongoProperties mongo) throws Exception {
	    return new SimpleMongoDbFactory(new MongoClient(mongo.getHost(), mongo.getPort()),
	            mongo.getDatabase());
	}

	@Bean
	public MongoDbFactory secondaryFactory(final MongoProperties mongo) throws Exception {
	    return new SimpleMongoDbFactory(new MongoClient(mongo.getHost(), mongo.getPort()),
	            mongo.getDatabase());
	}
	

}
