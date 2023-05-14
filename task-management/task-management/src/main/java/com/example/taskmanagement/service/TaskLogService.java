package com.example.taskmanagement.service;

import com.example.taskmanagement.dto.TaskLogDTO;

import java.util.List;

public interface TaskLogService {
    TaskLogDTO addTaskLog(TaskLogDTO taskLogDTO);
    List<TaskLogDTO> getAllTaskLog();
    void deleteTaskLog(long id);
    TaskLogDTO updateTaskLogById(TaskLogDTO taskLogDTO, long id);
    TaskLogDTO searchByName(String name);

}
