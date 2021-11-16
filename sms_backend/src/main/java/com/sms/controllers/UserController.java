package com.sms.controllers;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sms.dto.requests.Email;
import com.sms.dto.requests.UserRequest;
import com.sms.dto.responses.ResponseDTO;
import com.sms.entities.User;
import com.sms.repositories.UserRepository;
import com.sms.services.EmailService;
import com.sms.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserController {
	
	private static final Logger LOG = Logger.getLogger(UserController.class.getName());
	
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	PasswordEncoder encoder;
	
	@Autowired
	UserService userService;
	
	@Autowired
	EmailService emailService;
	
	@Value("${spring.mail.username}")
	private String from;

	/**
	 * Creates user
	 * @param userRequest
	 * @return
	 */
	@PostMapping(value = "/add")
	public ResponseEntity<ResponseDTO> addUser(@RequestBody UserRequest userRequest) {
		LOG.log(Level.INFO, "Add User api is called...");
		ResponseEntity<ResponseDTO> response = userService.addUser(userRequest);
		Email email = new Email();
		email.setFrom(from);
		email.setSubject("Registration");
		email.setTo(from);
		CompletableFuture.runAsync(() ->emailService.sendEmail(email, "Registration"));
		return response;
	}
	
	/**
	 * Updates User
	 * @param userRequest
	 * @return
	 */
	@PutMapping(value = "/update")
	public User updateUser(@RequestBody User userRequest) {
		LOG.log(Level.INFO, "Update User api is called...");
		userRequest.setPassword(encoder.encode(userRequest.getPassword()));
		return userRepo.save(userRequest);
	}
	
	/**
	 * Gets users list
	 * @return
	 */
	@GetMapping(value = "/getAll")
	public List<User> getUsers() {
		LOG.log(Level.INFO, "Get all Users api is called...");
		return userRepo.findAll();
	}
	
	/**
	 * Deletes user by ID
	 * @param id
	 * @return
	 */
	@DeleteMapping(value = "/delete/{id}")
	public String deleteUser(@PathVariable Long id) {
		LOG.log(Level.INFO, "Delete User api is called...");
		userRepo.deleteById(id);
		return "deleted successfully";
	}

}