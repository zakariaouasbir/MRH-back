package com.afma.mrh.dto;


import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class QuestionDto {
	
		private Long id;

	    @NotNull
	    private String content;
	    
	    @NotNull
	    private int ranking;
	
}
