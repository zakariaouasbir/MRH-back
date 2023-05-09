package com.afma.mrh.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.afma.mrh.entity.Subscription;
import com.afma.mrh.exception.ResourceNotFoundException;
import com.afma.mrh.repository.SubscriptionRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class SubscriptionService {

	@Autowired
	SubscriptionRepository subscriptionRepository;

	
	public List<Subscription> loadAllSubscriptions() {
		List<Subscription> subscriptions = subscriptionRepository.findAll();
		return subscriptions;
	}

	public Subscription getSubscriptionById(Long subscriptionId) throws ResourceNotFoundException {
		return  subscriptionRepository.findById(subscriptionId)
				.orElseThrow(() -> new ResourceNotFoundException("Subscription not found for this id :: " + subscriptionId));
	}

	public Subscription createSubscription(Subscription subscription) {
		Subscription createdsubscription = subscriptionRepository.save(subscription);
		return createdsubscription;
	}

	public Subscription UpdateSubscription(Long subscriptionId) throws ResourceNotFoundException {
		Subscription subscription = subscriptionRepository.findById(subscriptionId)
				.orElseThrow(() -> new ResourceNotFoundException("Subscription not found for this id :: " + subscriptionId ));

		final Subscription updatedSubscription = subscriptionRepository.save(subscription);
		return updatedSubscription;
	}

	public Map<String, Boolean> deleteSubscription(Long subscriptionId) throws ResourceNotFoundException {
		Subscription subscription = subscriptionRepository.findById(subscriptionId)
				.orElseThrow(() -> new ResourceNotFoundException("Subscription not found for this id :: " + subscriptionId));

		subscriptionRepository.delete(subscription);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

}
