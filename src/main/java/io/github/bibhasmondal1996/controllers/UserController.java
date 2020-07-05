package io.github.bibhasmondal1996.controllers;

import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.bibhasmondal1996.models.UserModel;
import io.github.bibhasmondal1996.repositories.UserRepository;

@RestController
@RequestMapping("user")
public class UserController {
	@Autowired
	UserRepository userRepository;
	@GetMapping(value= "")     
	public ResponseEntity<String> showArticleByUser(){
		return ResponseEntity.ok("Hello");
	}
	
	@GetMapping(value = "/bulkcreate")
	public String bulkcreate(){	
		// save a list of Customers
		userRepository.saveAll(
				Arrays.asList(
						new UserModel("Salim"),
                        new UserModel("Rajesh"),
                        new UserModel("Rahul"),
                        new UserModel("Dharmendra")
				)
		);
		return "Users are created";
	}

	@RequestMapping(value = "/get/{name}")
	public String get(@PathVariable(value="name") String name){
		String user = userRepository.findByName(name).toString();
		return user;
	}

	@GetMapping(value = "/create/{name}")
	public ResponseEntity<?> create(@PathVariable(value="name") String name){
		userRepository.save(new UserModel(name));
		return ResponseEntity.status(HttpStatus.OK).body("Created");
	}
}
