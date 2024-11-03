package com.siraj.quiz_app.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Quiz {
    @Id
    @GeneratedValue
    private Integer id;
    private String title;

    @ManyToMany
    private List<Question> questions;

}
