package com.chan.spring.friends.controller;

import java.util.Optional;

import javax.validation.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.chan.spring.friends.model.Friend;
import com.chan.spring.friends.service.FriendService;
import com.chan.spring.friends.util.ErrorMessage;

@RestController
public class FriendController {

	@Autowired
	FriendService friendService;

	@PostMapping("/friend")
	Friend create(@RequestBody Friend friend) {
		if(friend.getId() == 0 && friend.getFirstName() != null && friend.getLastName() != null) {
			return friendService.save(friend);
		} else throw new ValidationException("friend can not created");
	}
	
	/* Move to ControllerExceptionHandler.java because want to using @ControllerAdvice annotation. */
//	@ResponseStatus(HttpStatus.BAD_REQUEST)
//	@ExceptionHandler(ValidationException.class)
//	ErrorMessage exceptionHandler(ValidationException e){
//		return new ErrorMessage("400",e.getMessage());
//	}

	@GetMapping("/friend")
	Iterable<Friend> read() {
		return friendService.findAll();
	}
	
	@PutMapping("/friend")
	ResponseEntity<Friend> update(@RequestBody Friend friend) {
		if(friendService.findById(friend.getId()).isPresent()){
			return new ResponseEntity<Friend>(friendService.save(friend),HttpStatus.OK);
		}else {
			return new ResponseEntity<Friend>(friend,HttpStatus.BAD_GATEWAY);
		}
	}
	
	@DeleteMapping("/friend/{id}")
	void delete (@PathVariable Integer id) {
		friendService.deleteById(id);
	}
	
	@GetMapping("/friend/{id}")
	Optional<Friend> findById(@PathVariable Integer id){
		return friendService.findById(id);
	}
	
	@GetMapping("/friend/search")
	Iterable<Friend> findAll(
			@RequestParam(value = "first", required = false) String firstName, @RequestParam(value = "last", required = false) String lastName){
		if(firstName != null && lastName != null) {
			return friendService.findByFirstNameAndLastName(firstName, lastName);
		}else if (firstName != null) {
			return friendService.findByFirstName(firstName);
		}else if (lastName != null) {
			return friendService.findByLastName(lastName);
		}else	
		return friendService.findAll();
	}
}
