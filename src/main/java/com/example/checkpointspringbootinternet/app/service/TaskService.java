package com.example.checkpointspringbootinternet.app.service;

import com.example.checkpointspringbootinternet.app.data.TaskDTO;
import com.example.checkpointspringbootinternet.app.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;


public interface TaskService {

    TaskDTO createTask(TaskDTO taskDTO);
    List<TaskDTO> getAllTasks();
    TaskDTO getTaskById(long id) throws ResourceNotFoundException;
    void updateTaskById(long id , TaskDTO taskDTO) throws ResourceNotFoundException;
    void deleteTaskById(long id) throws ResourceNotFoundException;
}
