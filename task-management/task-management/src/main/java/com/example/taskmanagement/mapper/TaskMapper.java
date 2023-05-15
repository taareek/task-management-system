package com.example.taskmanagement.mapper;

import com.example.taskmanagement.dto.TaskDTO;
import com.example.taskmanagement.entity.Task;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TaskMapper {
    public TaskDTO mapTaskEntityToDto(Task task){
        TaskDTO taskDTO = new TaskDTO();
        taskDTO.setId(task.getId());
        taskDTO.setTaskName(task.getTaskName());
        taskDTO.setDescription(task.getDescription());
        taskDTO.setCreatedAt(task.getCreatedAt());
        taskDTO.setDueDate(task.getDueDate());
        taskDTO.setExpectedTime(task.getExpectedTime());
        taskDTO.setTaskPriorityLevel(task.getTaskPriorityLevel());
        taskDTO.setTaskStatus(task.getTaskStatus());
        taskDTO.setHasReminder(task.getHasReminder());
        taskDTO.setTaskCollection(task.getTaskCollection());
        return taskDTO;
    }

    public Task mapTaskDtoToEntity(TaskDTO taskDTO){
        Task task = new Task();
        task.setId(taskDTO.getId());
        task.setTaskName(taskDTO.getTaskName());
        task.setDescription(taskDTO.getDescription());
        task.setCreatedAt(taskDTO.getCreatedAt());
        task.setDueDate(taskDTO.getDueDate());
        task.setExpectedTime(taskDTO.getExpectedTime());
        task.setTaskPriorityLevel(taskDTO.getTaskPriorityLevel());
        task.setTaskStatus(taskDTO.getTaskStatus());
        task.setHasReminder(taskDTO.getHasReminder());
        task.setTaskCollection(taskDTO.getTaskCollection());
        return task;
    }
    public List<TaskDTO> mapTaskEntityListToTaskDtoList(List<Task> tasks) {
        return tasks.stream()
                .map(this::mapTaskEntityToDto)
                .collect(Collectors.toList());
    }
    public List<Task> mapTaskDtoListToTaskEnityList(List<TaskDTO> taskDtos){
        return taskDtos.stream()
                .map(this::mapTaskDtoToEntity)
                .collect(Collectors.toList());
    }
}
