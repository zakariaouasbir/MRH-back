package com.afma.mrh.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "mrs_user")
public class TargetUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
   
    @NotNull
    @Size(min = 3, max = 50)
    @Column(name = "firstname", unique=true)
    private String firstname;
    
    @NotNull
    @Size(min = 3, max = 50)
    @Column(name = "lastname", unique=true)
    private String lastname;
    
  
    @NotNull
    @Pattern(regexp = "^(0|\\+212)[5-7]\\d{8}$", message = "Phone number Not valid")
    private String phone;
 
   
    @Email(message = "Email should be valid")
    private String email;
    
    
    
    
}