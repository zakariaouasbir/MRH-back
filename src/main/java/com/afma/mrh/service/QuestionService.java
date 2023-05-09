package com.afma.mrh.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.afma.mrh.dto.QuestionDto;
import com.afma.mrh.entity.Question;
import com.afma.mrh.exception.ResourceNotFoundException;
import com.afma.mrh.mapper.QuestionMapper;
import com.afma.mrh.repository.QuestionRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class QuestionService {

	@Autowired
	QuestionRepository questionRepository;
	
	@Autowired
	private QuestionMapper questionMapper;
	
	public List<QuestionDto> loadAllQuestions() {
		return  questionMapper
				.MAPPER
				.mapToQuestionsDto(questionRepository.findAll()  );
		
	}

	public Question getQuestionById(Long questionId) throws ResourceNotFoundException {
		return  questionRepository.findById(questionId)
				.orElseThrow(() -> new ResourceNotFoundException("Question not found for this id :: " + questionId));
	}
	
	public QuestionDto getQuestionByRanking(int order)  {
		return  questionMapper
				.MAPPER
				.mapToQuestionDto(
								  questionRepository.findByRanking(order)
								  .get()
								  );
		}

	public QuestionDto createQuestion(Question question) {
		Question createdquestion = questionRepository.save(question);
		return questionMapper
				.MAPPER
				.mapToQuestionDto(createdquestion );
				
	}

	public Question UpdateQuestion(Long questionId) throws ResourceNotFoundException {
		Question question = questionRepository.findById(questionId)
				.orElseThrow(() -> new ResourceNotFoundException("Question not found for this id :: " + questionId ));

		final Question updatedQuestion = questionRepository.save(question);
		return updatedQuestion;
	}

	public Map<String, Boolean> deleteQuestion(Long questionId) throws ResourceNotFoundException {
		Question question = questionRepository.findById(questionId)
				.orElseThrow(() -> new ResourceNotFoundException("Question not found for this id :: " + questionId));

		questionRepository.delete(question);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

}
