package com.example.taskmanagement.service;

import com.example.taskmanagement.dto.TaskDTO;
import com.example.taskmanagement.entity.Task;

import java.util.List;

public interface TaskService {
    TaskDTO addTask(TaskDTO taskDTO);
    List<TaskDTO> getAllTask();
    void deleteTask(long id);
    TaskDTO updateTaskById(long id, TaskDTO taskDTO);
    Task searchTaskById(long id);

}
