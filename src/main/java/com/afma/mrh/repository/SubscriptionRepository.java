package com.afma.mrh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.afma.mrh.entity.Devis;
import com.afma.mrh.entity.Subscription;


@Repository
public interface SubscriptionRepository extends JpaRepository<Subscription, Long>{}
       
