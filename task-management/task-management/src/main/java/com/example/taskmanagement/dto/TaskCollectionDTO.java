package com.example.taskmanagement.dto;

import com.example.taskmanagement.entity.Task;

import java.time.Instant;
import java.util.List;

public class TaskCollectionDTO {
    private Long id;
    private String taskCollectionName;
    private Instant createdAt;
//    private List<Task> tasks;

    public TaskCollectionDTO() {}

    public TaskCollectionDTO(Long id, String taskCollectionName, Instant createdAt) {
        this.id = id;
        this.taskCollectionName = taskCollectionName;
        this.createdAt = createdAt;
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

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
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
                ", createdAt=" + createdAt +
                '}';
    }
}
