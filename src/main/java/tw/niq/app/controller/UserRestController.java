package tw.niq.app.controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tw.niq.app.model.request.UpdateUserDetailsRequestModel;
import tw.niq.app.model.request.UserDetailsRequestModel;
import tw.niq.app.model.response.UserRest;
import tw.niq.app.service.UserService;

@RestController
@RequestMapping("users")
public class UserRestController {
	
	private final UserService userService;
		
	public UserRestController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping
	public String getUsers(
			@RequestParam(value = "page", defaultValue = "1") int page, 
			@RequestParam(value = "limit", defaultValue = "10") int limit, 
			@RequestParam(value = "sort", defaultValue = "desc", required = false) String sort) {
		return "get users was called with page = " + page + " and limit = " + limit + " and srot = " + sort;
	}

	@GetMapping(path = "/{userId}", 
			produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<UserRest> getUser(@PathVariable String userId) {
		
		UserRest returnValue = userService.getUser(userId);
		
		if (returnValue != null) {
			return new ResponseEntity<>(userService.getUser(userId), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
	
	@PostMapping(
			consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE}, 
			produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<UserRest> createUser(
			@Valid @RequestBody UserDetailsRequestModel userDetails) {
		
		UserRest returnValue = userService.createUser(userDetails);
		
		return new ResponseEntity<>(returnValue, HttpStatus.CREATED);
	}
	
	@PutMapping(path = "/{userId}", 
			consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE}, 
			produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<UserRest> updateUser(@PathVariable String userId, 
			@Valid @RequestBody UpdateUserDetailsRequestModel userDetails) {
		
		UserRest storedUserDetails = userService.updateUser(userId, userDetails);
		
		if (storedUserDetails != null) {
			return new ResponseEntity<>(storedUserDetails, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
	
	@DeleteMapping(path = "/{userId}")
	public ResponseEntity<UserRest> deleteUser(@PathVariable String userId) {
		
		userService.deleteUser(userId);
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
}
