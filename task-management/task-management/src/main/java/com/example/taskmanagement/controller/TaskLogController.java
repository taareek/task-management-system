package com.example.taskmanagement.controller;

import com.example.taskmanagement.dto.TaskLogDTO;
import com.example.taskmanagement.service.TaskLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin()
@RequestMapping("api/tasks/logs")
public class TaskLogController {
    @Autowired
    private TaskLogService taskLogService;

    @PostMapping(path="/create")
    public TaskLogDTO createTaskLog(@RequestBody TaskLogDTO taskLogDTO){
        TaskLogDTO taskLog = taskLogService.addTaskLog(taskLogDTO);
        return taskLog;
    }
    @GetMapping(path="all-logs")
    public List<TaskLogDTO> getAllLogs(){
        return taskLogService.getAllTaskLog();
    }
}
