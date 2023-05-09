package com.afma.mrh.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import jakarta.persistence.*;

@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "mrs_question")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    
    @Temporal(TemporalType.DATE)
    @Column(name="createDate") 
    private Date createDate;
    
    @NotNull
    @Size(min = 10, max = 999)
    @Column(name="content") 
    private String content;
    
    @NotNull
    @Column(name="ranking") 
    private int ranking;
    
    
    
}