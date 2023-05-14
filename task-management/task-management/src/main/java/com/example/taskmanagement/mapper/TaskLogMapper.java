package com.example.taskmanagement.mapper;

import com.example.taskmanagement.dto.TaskLogDTO;
import com.example.taskmanagement.entity.TaskLog;

public class TaskLogMapper {
    public TaskLogDTO mapTaskLogEntityToDto(TaskLog taskLog){
        TaskLogDTO taskLogDTO = new TaskLogDTO();
        taskLogDTO.setId(taskLog.getId());
        taskLogDTO.setSpentTime(taskLog.getSpentTime());
        taskLogDTO.setLogDate(taskLog.getLogDate());
        taskLogDTO.setLogNote(taskLog.getLogNote());
        taskLogDTO.setTask(taskLog.getTask());
        return taskLogDTO;
    }

    public TaskLog mapTaskLogDTOtoEntity(TaskLogDTO taskLogDTO){
        TaskLog taskLog = new TaskLog();
        taskLog.setId(taskLogDTO.getId());
        taskLog.setSpentTime(taskLogDTO.getSpentTime());
        taskLog.setLogDate(taskLogDTO.getLogDate());
        taskLog.setLogNote(taskLogDTO.getLogNote());
        taskLog.setTask(taskLogDTO.getTask());
        return taskLog;
    }
}
