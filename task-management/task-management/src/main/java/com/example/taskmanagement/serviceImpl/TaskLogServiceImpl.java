package com.example.taskmanagement.serviceImpl;

import com.example.taskmanagement.dto.TaskLogDTO;
import com.example.taskmanagement.entity.TaskLog;
import com.example.taskmanagement.mapper.TaskLogMapper;
import com.example.taskmanagement.repo.TaskLogRepo;
import com.example.taskmanagement.service.TaskLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class TaskLogServiceImpl implements TaskLogService {
    @Autowired
    private final TaskLogRepo taskLogRepo;
    private final TaskLogMapper taskLogMapper;

    public TaskLogServiceImpl(TaskLogRepo taskLogRepo, TaskLogMapper taskLogMapper) {
        this.taskLogRepo = taskLogRepo;
        this.taskLogMapper = taskLogMapper;
    }

    @Override
    public TaskLogDTO addTaskLog(TaskLogDTO taskLogDTO) {
        TaskLog taskLog = taskLogMapper.mapTaskLogDTOtoEntity(taskLogDTO);
        TaskLog savedTaskLog = taskLogRepo.save(taskLog);
        return taskLogMapper.mapTaskLogEntityToDto(savedTaskLog);
    }

    @Override
    public List<TaskLogDTO> getAllTaskLog() {
        List<TaskLog> taskLogs = taskLogRepo.findAll();
        return taskLogMapper.mapTaskLogEntityListToTaskLogDtoList(taskLogs);
    }

    @Override
    public void deleteTaskLog(long id) {
        taskLogRepo.deleteById(id);
    }

    @Override
    public TaskLogDTO updateTaskLogById(TaskLogDTO taskLogDTO, long id) {
        TaskLog providedTaskLog = taskLogRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Task not found for the ID: " + id));

        providedTaskLog.setId(taskLogDTO.getId());
        providedTaskLog.setSpentTime(taskLogDTO.getSpentTime());
        providedTaskLog.setLogNote(taskLogDTO.getLogNote());
        providedTaskLog.setLogDate(taskLogDTO.getLogDate());
        providedTaskLog.setTask(taskLogDTO.getTask());

        TaskLog updatedTaskLog = taskLogRepo.save(providedTaskLog);
        return taskLogMapper.mapTaskLogEntityToDto(updatedTaskLog);
    }

    @Override
    public TaskLogDTO searchByName(String name) {
        return null;
    }
}
