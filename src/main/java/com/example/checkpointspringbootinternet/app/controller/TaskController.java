package com.example.checkpointspringbootinternet.app.controller;

import com.example.checkpointspringbootinternet.app.data.TaskDTO;
import com.example.checkpointspringbootinternet.app.exception.ResourceNotFound;
import com.example.checkpointspringbootinternet.app.service.TaskService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * the task controller.
 * @author kamar baraka.*/

@AllArgsConstructor
@RestController
@RequestMapping(value = {"/api/v1/tasks"})
@Tag(name = "Task Management System", description = "an api to perform CRUD operations on a task")
public class TaskController {

    private TaskService taskService;


    @GetMapping
    @Operation(summary = "get all tasks")
    public ResponseEntity<List<TaskDTO>> getAllTasks() throws ResourceNotFound {

        /*get all tasks*/
        List<TaskDTO> allTasks = this.taskService.getAllTasks();
        /*return the list of tasks*/
        return ResponseEntity.ok(allTasks);
    }

    @GetMapping(value = {"{id}"})
    @Operation(summary = "get a task by id")
    public ResponseEntity<TaskDTO> getTaskById(@PathVariable("id") long id) throws ResourceNotFound {

        /*get the task by id*/
        TaskDTO task = this.taskService.getTaskById(id);
        /*return the task*/
        return ResponseEntity.ok(task);
    }

    @PostMapping
    @Operation(summary = "create a task")
    public ResponseEntity<TaskDTO> createTask(@Valid @RequestBody TaskDTO taskDTO){

        /*create a task*/
        TaskDTO task = this.taskService.createTask(taskDTO);
        /*return the created task*/
        return ResponseEntity.status(HttpStatus.CREATED).body(task);
    }

    @PutMapping(value = {"{id}"})
    @Operation(summary = "update a task")
    @ResponseStatus(HttpStatus.OK)
    public void updateTask(@Valid @RequestBody TaskDTO taskDTO, @PathVariable("id") long id) throws ResourceNotFound {

        /*update the task*/
        this.taskService.updateTaskById(id, taskDTO);
    }

    @DeleteMapping(value = {"{id}"})
    @Operation(summary = "delete a task by id")
    public void deleteTaskById(@PathVariable("id") long id)throws ResourceNotFound {

        /*delete the task*/
        this.taskService.deleteTaskById(id);
    }
}
