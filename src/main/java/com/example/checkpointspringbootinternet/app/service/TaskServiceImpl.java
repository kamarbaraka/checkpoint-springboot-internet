package com.example.checkpointspringbootinternet.app.service;

import com.example.checkpointspringbootinternet.app.data.TaskDTO;
import com.example.checkpointspringbootinternet.app.entity.Task;
import com.example.checkpointspringbootinternet.app.exception.ResourceNotFound;
import com.example.checkpointspringbootinternet.app.repository.TaskRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * the task service implementation.*/

@Service
@AllArgsConstructor
public class TaskServiceImpl implements TaskService {

    private TaskRepository taskRepository;
    private ModelMapper mapper;

    private TaskDTO convertToDTO(Task task){

        return this.mapper.map(task, TaskDTO.class);
    }

    private Task convertToTask(TaskDTO taskDTO){

        return this.mapper.map(taskDTO, Task.class);
    }

    private Task findOrThrow(long id)throws ResourceNotFound {

        /*find the task or throw an exception*/
        return this.taskRepository.findById(id).orElseThrow(ResourceNotFound::new);
    }
    @Override
    public TaskDTO createTask(TaskDTO taskDTO) {

        /*map the task dto to the entity*/
        Task task = convertToTask(taskDTO);
        /*persist the task*/
        Task persistedTask = this.taskRepository.save(task);
        /*map to dto and return*/
        return convertToDTO(persistedTask);

    }

    @Override
    public List<TaskDTO> getAllTasks() {

        /*get all tasks*/
        List<Task> allTasks = this.taskRepository.findAll();
        /*map all tasks to dto*/
        return allTasks.stream().map(this::convertToDTO).toList();
    }

    @Override
    public TaskDTO getTaskById(long id) throws ResourceNotFound {

        Task task = this.findOrThrow(id);
        /*convert to dto*/
        return convertToDTO(task);
    }

    @Override
    public void updateTaskById(long id, TaskDTO taskDTO) throws ResourceNotFound {

        /*check if the task exists*/
        this.findOrThrow(id);
        /*update the task*/
        this.taskRepository.save(convertToTask(taskDTO));

    }

    @Transactional
    @Override
    public void deleteTaskById(long id) throws ResourceNotFound {

        /*check if the task exists*/
        this.findOrThrow(id);
        /*delete the task*/
        this.taskRepository.deleteById(id);
    }
}
