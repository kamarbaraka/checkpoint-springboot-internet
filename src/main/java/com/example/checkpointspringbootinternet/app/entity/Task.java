package com.example.checkpointspringbootinternet.app.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;


import java.time.LocalDate;

/**
 * the task entity.*/


@Entity
@Getter
@Setter
public class Task {
    @Id
    @GeneratedValue(generator = "Long")
    @Column(updatable = false, nullable = false)
    private Long id;
    private String title;
    private String description;
    private boolean completed;
    private LocalDate dueDate;
}
