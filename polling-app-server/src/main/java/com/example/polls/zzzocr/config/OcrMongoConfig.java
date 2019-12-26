package com.example.polls.zzzocr.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.example.polls.zzzocr.repository.OcrUserRepository;

import com.mongodb.MongoClient;

@Configuration

//@EnableMongoRepositories("com.example.polls.zzzocr.repository")


// here we enable the second database of our project test db for a ocr process we individually handle this one 
@EnableMongoRepositories(basePackages = "com.example.polls.zzzocr.repository",mongoTemplateRef = "secondaryMongoTemplate")
public class OcrMongoConfig extends AbstractMongoConfiguration {

	@Override
	public MongoClient mongoClient() {
		return new MongoClient();
	}

	@Override
	protected String getDatabaseName() {
		return "test-db";
	}
}
//samran tech PVT LMT