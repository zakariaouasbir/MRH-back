package com.afma.mrh.controller;

import java.security.Principal;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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

import com.afma.mrh.dto.QuestionDto;
import com.afma.mrh.entity.Question;
import com.afma.mrh.exception.ResourceNotFoundException;
import com.afma.mrh.service.QuestionService;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1")
public class QuestionController {
	

	@Autowired
	private QuestionService questionService;

	
	@GetMapping("/question")
	public List<QuestionDto>  getAllQuestion() {
		return questionService.loadAllQuestions(); 
	}

	@GetMapping("/question/{id}")
	public ResponseEntity<Question> getQuestionById(@PathVariable(value = "id") Long questionId)
			throws ResourceNotFoundException {
		Question question = questionService.getQuestionById(questionId);
		return ResponseEntity.ok().body(question);
	}
	
	@GetMapping("/questionByRanking/{ranking}")
	public QuestionDto getQuestionByRanking(@PathVariable(value = "ranking") int ranking)
			throws ResourceNotFoundException {
		return questionService.getQuestionByRanking(ranking);
		 
	}

	@PostMapping("/question")
	public QuestionDto createQuestion(@Valid @RequestBody Question question, Principal p) {
		return questionService.createQuestion(question);
	}

	@PutMapping("/question/{id}")
	public ResponseEntity<Question> updateQuestion(
			@PathVariable(value = "id") Long questionId,
			@Valid @RequestBody Question questionDetails) throws ResourceNotFoundException {

		//final Question updatedQuestion = questionService.UpdateQuestion(questionDetails);
		return ResponseEntity.ok(questionDetails);
	}

	@PatchMapping("/question/{id}")
	public ResponseEntity<Question> updateQuestionpatch(
			@PathVariable(value = "id") Long questionId,
			@Valid @RequestBody Question questionDetails) throws ResourceNotFoundException {
	//	final Question updatedQuestion = questionService.UpdateQuestion(questionDetails);
		return ResponseEntity.ok(questionDetails);
	}

	
	// @PreAuthorize("hasAnyRole('ROLE_admin')")
	@ResponseBody
	@DeleteMapping("/question/{id}")
	public Map<String, Boolean> deleteQuestion(@PathVariable(value = "id") Long questionId) throws ResourceNotFoundException {
		return questionService.deleteQuestion(questionId);
	}

}
