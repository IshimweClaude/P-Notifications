package com.notification.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.notification.entity.Notification;
import com.notification.exception.ResourceNotFoundException;
import com.notification.repository.NotificationRepository;

@RestController
@RequestMapping("/api/notification")
public class NotificationController {
	
	@Autowired
	private NotificationRepository notificationRepository;
	
//	Welcoming message
	@GetMapping("/welcome")
	public String welcome() {
		
		return "Welcome to Park & Pick users";
	}
	
	// get all users
	@GetMapping("/all")
	public List<Notification> getAllProducts(){
    	System.out.println("All notifications are listed here");
		return this.notificationRepository.findAll();
    }
	// get user by id
	@GetMapping("/{id}")
	public Notification getUseById(@PathVariable(value = "id") Long order_id) {
		
		return this.notificationRepository.findById(order_id)
				.orElseThrow(() -> new ResourceNotFoundException("Notification not found with id: "+ order_id));
	
	}
	// create user 
	
	@PostMapping("/register")
	
	public Notification createUser(@RequestBody Notification notification) {
		
		return this.notificationRepository.save(notification);
	}
	
	// update user
	@PutMapping("/{id}")
	public Notification updateUser(@RequestBody Notification notification, @PathVariable("id") Long notification_id) {
		Notification existing = this.notificationRepository.findById(notification_id)
				.orElseThrow(() -> new ResourceNotFoundException("Notification not found with id: "+ notification_id));
		existing.setRecipient_id(notification.getRecipient_id());
						
		this.notificationRepository.save(existing);
		return existing;
	}
	//delete user by id
    
	@DeleteMapping("/{id}")
	public ResponseEntity<Notification> deleteUser(@PathVariable("id") Long id){
		Notification existing = this.notificationRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Notification not found with id: "+ id));
	    this.notificationRepository.delete(existing);
	    return ResponseEntity.ok().build();
	}
}
