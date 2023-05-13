package com.example.taskmanagement.service;

import com.example.taskmanagement.dto.TaskCollectionDTO;
import com.example.taskmanagement.entity.TaskCollection;

import java.util.List;

public interface TaskCollectionService {
    TaskCollection addTaskCollection(TaskCollectionDTO taskCollectionDTO);

    List<TaskCollection> getAllTaskCollection();
    void deleteTaskCollection(long id);
    TaskCollection updateTaskCollection(TaskCollection taskCollection);
    TaskCollection searchTaskCollectionById(long id);
}
