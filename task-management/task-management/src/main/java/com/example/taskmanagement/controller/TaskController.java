package com.example.taskmanagement.controller;

import com.example.taskmanagement.dto.TaskDTO;
import com.example.taskmanagement.entity.Task;
import com.example.taskmanagement.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin()
@RequestMapping("api/tasks")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @PostMapping(path="/create")
    public TaskDTO createTask(@RequestBody TaskDTO taskDTO){
        TaskDTO task = taskService.addTask(taskDTO);
        return task;
    }
    @GetMapping(path="/all-tasks")
    public List<TaskDTO> getAllTasks(){
        return taskService.getAllTask();
    }
}
