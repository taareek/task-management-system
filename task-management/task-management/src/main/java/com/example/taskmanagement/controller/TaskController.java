package com.example.taskmanagement.controller;

import com.example.taskmanagement.dto.TaskDTO;
import com.example.taskmanagement.entity.Task;
import com.example.taskmanagement.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
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

    @GetMapping(path="task-id/{taskId}")
    public TaskDTO getTaskById(@PathVariable("taskId") long taskId){
        return taskService.searchTaskById(taskId);
    }

    @PutMapping(path="update/{taskId}")
    public TaskDTO updateTaskById(@RequestBody TaskDTO taskDTO, @PathVariable("taskId") long taskId){
        TaskDTO task = taskService.updateTaskById(taskId, taskDTO);
        return task;
    }
    @PostMapping(path="update-task")
    public TaskDTO updateTask(@RequestBody TaskDTO taskDTO){
        TaskDTO task = taskService.updateTask(taskDTO);
        return task;
    }
}
