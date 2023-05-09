package com.afma.mrh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.afma.mrh.entity.Devis;


@Repository
public interface DevisRepository extends JpaRepository<Devis, Long>{}
       
