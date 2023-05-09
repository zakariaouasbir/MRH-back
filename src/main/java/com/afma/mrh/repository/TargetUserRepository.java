package com.afma.mrh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.afma.mrh.entity.TargetUser;


@Repository
public interface TargetUserRepository extends JpaRepository<TargetUser, Long>{}
       
