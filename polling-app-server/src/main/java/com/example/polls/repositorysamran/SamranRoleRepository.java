package com.example.polls.repositorysamran;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.polls.modelsamran.Role;


//repo for spring with mongo register -after oauth
public interface SamranRoleRepository  extends MongoRepository<Role, String> 

{
	 Role findByRole(String role);

}
//samran tech PVT LMT