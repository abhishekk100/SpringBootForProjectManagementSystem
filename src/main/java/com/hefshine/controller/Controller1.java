package com.hefshine.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hefshine.model.User;
import com.hefshine.exception.*;
import com.hefshine.repository.UserRepository;

@CrossOrigin
@RestController
@RequestMapping("con1")
public class Controller1 {
	
	@Autowired 
	UserRepository userrepository;
	
	
	
	@PostMapping("/addUser")
	public boolean addUser(@RequestBody User user) {
		
		try
		{
			System.out.println(user);
			int count = userrepository.countByName(user.getName());
			if(count==0)
			{
				userrepository.save(user);
			return true;
			}
			else
				return false;
		}
		catch (Exception e) {

			e.printStackTrace();
			return false;
		}
	}
	@DeleteMapping("deleteUser/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteUser(@PathVariable int id)
	{

User user = userrepository.findById(id)
.orElseThrow(() ->new ResourceNotFound("User dose not exist with id: "+id));
userrepository.delete(user);
//retun response to user with message
		Map<String, Boolean> response = new HashMap<>();
		response.put("User Deleted", Boolean.TRUE);
		
		return ResponseEntity.ok(response);

	}
	@PostMapping("checkuser")
	public boolean checkLoginUser(@RequestBody User user) {
		
		List<User> us = userrepository.findAll();
		int cn =0 ;
			for (int i = 0; i < us.size(); i++) {
				if(us.get(i).getName().equals(user.getName())&&us.get(i).getPassword().equals(user.getPassword()))
				{
					return true;
				}
			}
			return  false;
			
		
	}

}
