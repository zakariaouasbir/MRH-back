package com.afma.mrh.controller;

import java.security.Principal;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.afma.mrh.entity.Subscription;
import com.afma.mrh.exception.ResourceNotFoundException;
import com.afma.mrh.service.SubscriptionService;


@RestController
@RequestMapping("/api/v1")
public class SubscriptionController {
	

	@Autowired
	private SubscriptionService subscriptionService;

	
	@GetMapping("/subscription")
	public List<Subscription> getAllSubscription() {
		return subscriptionService.loadAllSubscriptions();
	}

	@GetMapping("/subscription/{id}")
	public ResponseEntity<Subscription> getSubscriptionById(@PathVariable(value = "id") Long subscriptionId)
			throws ResourceNotFoundException {
		Subscription subscription = subscriptionService.getSubscriptionById(subscriptionId);
		return ResponseEntity.ok().body(subscription);
	}

	@PostMapping("/subscription")
	public Subscription createSubscription(@Valid @RequestBody Subscription subscription, Principal p) {
		return subscriptionService.createSubscription(subscription);
	}

	@PutMapping("/subscription/{id}")
	public ResponseEntity<Subscription> updateSubscription(
			@PathVariable(value = "id") Long subscriptionId,
			@Valid @RequestBody Subscription subscriptionDetails) throws ResourceNotFoundException {

		//final Subscription updatedSubscription = subscriptionService.UpdateSubscription(subscriptionDetails);
		return ResponseEntity.ok(subscriptionDetails);
	}

	@PatchMapping("/subscription/{id}")
	public ResponseEntity<Subscription> updateSubscriptionpatch(
			@PathVariable(value = "id") Long subscriptionId,
			@Valid @RequestBody Subscription subscriptionDetails) throws ResourceNotFoundException {
	//	final Subscription updatedSubscription = subscriptionService.UpdateSubscription(subscriptionDetails);
		return ResponseEntity.ok(subscriptionDetails);
	}

	
	// @PreAuthorize("hasAnyRole('ROLE_admin')")
	@ResponseBody
	@DeleteMapping("/subscription/{id}")
	public Map<String, Boolean> deleteSubscription(@PathVariable(value = "id") Long subscriptionId) throws ResourceNotFoundException {
		return subscriptionService.deleteSubscription(subscriptionId);
	}

}
