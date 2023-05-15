package com.example.taskmanagement.dto;

import com.example.taskmanagement.entity.Task;

import java.util.List;

public class TaskCollectionDTO {
    private Long id;
    private String taskCollectionName;
//    private List<Task> tasks;

    public TaskCollectionDTO() {}

    public TaskCollectionDTO(Long id, String taskCollectionName) {
        this.id = id;
        this.taskCollectionName = taskCollectionName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTaskCollectionName() {
        return taskCollectionName;
    }

    public void setTaskCollectionName(String taskCollectionName) {
        this.taskCollectionName = taskCollectionName;
    }

//    public List<Task> getTasks() {
//        return tasks;
//    }

//    public void setTasks(List<Task> tasks) {
//        this.tasks = tasks;
//    }

    @Override
    public String toString() {
        return "TaskCollectionDTO{" +
                "id=" + id +
                ", taskCollectionName='" + taskCollectionName + '\'' +
                '}';
    }
}
