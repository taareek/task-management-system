package com.example.taskmanagement.controller;

import com.example.taskmanagement.dto.TaskLogDTO;
import com.example.taskmanagement.entity.TaskLog;
import com.example.taskmanagement.service.TaskLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
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

    @PutMapping(path="/update/{taskLogId}")
    public TaskLogDTO updateTaskLog(@PathVariable("taskLogId") long taskLogId, @RequestBody TaskLogDTO taskLogDTO){
        TaskLogDTO taskLog = taskLogService.updateTaskLogById(taskLogDTO, taskLogId);
        return taskLog;
    }

    @GetMapping(path="task-log/{taskLogId}")
    public TaskLogDTO getTaskLogById(@PathVariable("taskLogId") long taskLogId){
        return taskLogService.searchById(taskLogId);
    }
}
