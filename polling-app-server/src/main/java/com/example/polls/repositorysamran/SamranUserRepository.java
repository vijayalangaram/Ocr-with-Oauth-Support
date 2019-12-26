package com.example.polls.repositorysamran;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.polls.modelsamran.User;

//repo for spring with mongo register -after oauth
public interface SamranUserRepository extends MongoRepository<User, String>  

{
	User findByEmail(String email);
    
	
}
//samran tech PVT LMT