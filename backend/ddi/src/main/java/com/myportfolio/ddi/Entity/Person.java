package com.myportfolio.ddi.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Person {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull
    @Size(min = 1, max = 25, message = "Length error")
    private String name;
    
    @NotNull
    @Size(min = 1, max = 25, message = "Length error")
    private String lastname;
    
    @NotNull
    @Size(min = 1, max = 100, message = "Length error")
    private String img;
}
