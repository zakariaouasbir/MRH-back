package com.afma.mrh.mapper;
import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import com.afma.mrh.dto.QuestionDto;
import com.afma.mrh.entity.Question;

@Mapper(componentModel = "spring")
public interface QuestionMapper {
	QuestionMapper MAPPER = Mappers.getMapper(QuestionMapper.class ); 
	
	
	QuestionDto mapToQuestionDto(Question q);
    Question mapToQuestion(QuestionDto q);
    List<QuestionDto> mapToQuestionsDto(List<Question> source);
    List<Question> mapToQuestions(List<QuestionDto> source);
   
}