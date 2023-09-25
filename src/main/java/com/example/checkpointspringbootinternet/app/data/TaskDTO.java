package com.example.checkpointspringbootinternet.app.data;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

/**
 * the task dto*/

@Getter
@Setter
public class TaskDTO {

    private String title;
    private String description;
    private boolean completed;
    private LocalDate dueDate;
}
