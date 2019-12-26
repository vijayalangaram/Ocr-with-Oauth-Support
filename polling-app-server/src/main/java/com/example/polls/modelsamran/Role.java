package com.example.polls.modelsamran;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;


// create class role for after the oauth to register in a mongodb
@Document(collection = "role")
public class Role 
{
	
	  	@Id
	    private String id;
	    @Indexed(unique = true, direction = IndexDirection.DESCENDING, dropDups = true)	    
	    private String role;
	    
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getRole() {
			return role;
		}
		public void setRole(String role) {
			this.role = role;
		}
	
}

//samran tech PVT LMT
