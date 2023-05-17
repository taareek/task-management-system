package com.example.taskmanagement.mapper;

import com.example.taskmanagement.dto.TaskLogDTO;
import com.example.taskmanagement.entity.TaskLog;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class TaskLogMapper {
    public TaskLogDTO mapTaskLogEntityToDto(TaskLog taskLog){
        TaskLogDTO taskLogDTO = new TaskLogDTO();
        taskLogDTO.setId(taskLog.getId());
        taskLogDTO.setSpentTime(taskLog.getSpentTime());
        taskLogDTO.setLogDate(Instant.now());
        taskLogDTO.setLogNote(taskLog.getLogNote());
        taskLogDTO.setTask(taskLog.getTask());
        return taskLogDTO;
    }

    public TaskLog mapTaskLogDTOtoEntity(TaskLogDTO taskLogDTO){
        TaskLog taskLog = new TaskLog();
        taskLog.setId(taskLogDTO.getId());
        taskLog.setSpentTime(taskLogDTO.getSpentTime());
        taskLog.setLogDate(Instant.now());
        taskLog.setLogNote(taskLogDTO.getLogNote());
        taskLog.setTask(taskLogDTO.getTask());
        return taskLog;
    }

    public List<TaskLogDTO> mapTaskLogEntityListToTaskLogDtoList(List<TaskLog> taskLogs) {
        return taskLogs.stream()
                .map(this::mapTaskLogEntityToDto)
                .collect(Collectors.toList());
    }

    public List<TaskLog> mapTaskLogDtoListToTaskLogEntity(List<TaskLogDTO> taskLogDTOS){
        return taskLogDTOS.stream()
                .map(this::mapTaskLogDTOtoEntity)
                .collect(Collectors.toList());
    }
}
