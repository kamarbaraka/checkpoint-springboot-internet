package com.example.checkpointspringbootinternet.app.repository;

import com.example.checkpointspringbootinternet.app.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * the task repository.*/

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
}
