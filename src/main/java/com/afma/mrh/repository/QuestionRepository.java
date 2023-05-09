package com.afma.mrh.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.afma.mrh.entity.Question;



@Repository
public interface QuestionRepository extends JpaRepository<Question, Long>{
	
	Optional<Question> findByRanking(int order);
	
}
       
