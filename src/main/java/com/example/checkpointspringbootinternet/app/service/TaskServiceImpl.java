package com.example.checkpointspringbootinternet.app.service;

import com.example.checkpointspringbootinternet.app.data.TaskDTO;
import com.example.checkpointspringbootinternet.app.entity.Task;
import com.example.checkpointspringbootinternet.app.exception.ResourceNotFoundException;
import com.example.checkpointspringbootinternet.app.repository.TaskRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

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
    public TaskDTO getTaskById(long id) throws ResourceNotFoundException {

        Task task = this.taskRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException());
        /*convert to dto*/
        return convertToDTO(task);
    }

    @Override
    public void updateTaskById(long id, TaskDTO taskDTO) {

        Task task = this.taskRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException());

        Task savedTask = this.taskRepository.save(convertToTask(taskDTO));

    }

    @Override
    public void deleteTaskById(long id) {

    }
}
