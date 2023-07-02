package com.example.taskmanagement.mapper;

import com.example.taskmanagement.dto.TaskCollectionDTO;
import com.example.taskmanagement.entity.TaskCollection;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
public class TaskCollectionMapper {
    public TaskCollectionDTO mapTaskCollectionEntityToDto(TaskCollection taskCollection){
        TaskCollectionDTO taskCollectionDTO = new TaskCollectionDTO();
        taskCollectionDTO.setId(taskCollection.getId());
        taskCollectionDTO.setTaskCollectionName(taskCollection.getTaskCollectionName());
        taskCollectionDTO.setCreatedAt(Instant.now());
        return taskCollectionDTO;
    }

    public TaskCollection mapTaskCollectionDtoToEntity(TaskCollectionDTO taskCollectionDTO){
        TaskCollection taskCollection = new TaskCollection();
        taskCollection.setId(taskCollectionDTO.getId());
        taskCollection.setTaskCollectionName(taskCollectionDTO.getTaskCollectionName());
        taskCollection.setCreatedAt(Instant.now());
        return taskCollection;
    }
}
