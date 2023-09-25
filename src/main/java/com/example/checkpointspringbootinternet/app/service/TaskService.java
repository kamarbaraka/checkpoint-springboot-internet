package com.example.checkpointspringbootinternet.app.service;

import com.example.checkpointspringbootinternet.app.data.TaskDTO;
import com.example.checkpointspringbootinternet.app.exception.ResourceNotFound;

import java.util.List;


public interface TaskService {

    TaskDTO createTask(TaskDTO taskDTO);
    List<TaskDTO> getAllTasks();
    TaskDTO getTaskById(long id) throws ResourceNotFound;
    void updateTaskById(long id , TaskDTO taskDTO) throws ResourceNotFound;
    void deleteTaskById(long id) throws ResourceNotFound;
}
