package com.afma.mrh.dto;

import java.sql.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class SubscriptionDto {
	
		@NotNull   
	    private Date createDate;
	    
	    @NotNull
	    @Size(min = 10, max = 999)
	    private String content;
	    
	    @NotNull
	    private int ranking;
	
}
