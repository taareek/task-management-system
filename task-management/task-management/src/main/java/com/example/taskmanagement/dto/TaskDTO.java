package com.example.taskmanagement.dto;

import com.example.taskmanagement.entity.TaskCollection;
import com.example.taskmanagement.entity.TaskLog;
import com.example.taskmanagement.enums.TaskPriorityLevel;
import com.example.taskmanagement.enums.TaskStatus;

import java.time.Instant;
import java.time.LocalDate;
import java.util.List;

public class TaskDTO {
    private Long id;
    private String taskName;
    private String description;
    private Instant createdAt;
    private LocalDate dueDate;
    private Double expectedTime;
    private TaskPriorityLevel taskPriorityLevel;
    private TaskStatus taskStatus;
    private Boolean hasReminder;
    private TaskCollection taskCollection;
    private List<TaskLog> taskLogs;

    public TaskDTO() {}

    public TaskDTO(Long id, String taskName, String description, Instant createdAt, LocalDate dueDate,
                   Double expectedTime, TaskPriorityLevel taskPriorityLevel, TaskStatus taskStatus,
                   Boolean hasReminder, TaskCollection taskCollection, List<TaskLog> taskLogs) {
        this.id = id;
        this.taskName = taskName;
        this.description = description;
        this.createdAt = createdAt;
        this.dueDate = dueDate;
        this.expectedTime = expectedTime;
        this.taskPriorityLevel = taskPriorityLevel;
        this.taskStatus = taskStatus;
        this.hasReminder = hasReminder;
        this.taskCollection = taskCollection;
        this.taskLogs = taskLogs;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public Double getExpectedTime() {
        return expectedTime;
    }

    public void setExpectedTime(Double expectedTime) {
        this.expectedTime = expectedTime;
    }

    public TaskPriorityLevel getTaskPriorityLevel() {
        return taskPriorityLevel;
    }

    public void setTaskPriorityLevel(TaskPriorityLevel taskPriorityLevel) {
        this.taskPriorityLevel = taskPriorityLevel;
    }

    public TaskStatus getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(TaskStatus taskStatus) {
        this.taskStatus = taskStatus;
    }

    public Boolean getHasReminder() {
        return hasReminder;
    }

    public void setHasReminder(Boolean hasReminder) {
        this.hasReminder = hasReminder;
    }

    public TaskCollection getTaskCollection() {
        return taskCollection;
    }

    public void setTaskCollection(TaskCollection taskCollection) {
        this.taskCollection = taskCollection;
    }

    public List<TaskLog> getTaskLogs() {
        return taskLogs;
    }

    public void setTaskLogs(List<TaskLog> taskLogs) {
        this.taskLogs = taskLogs;
    }

    @Override
    public String toString() {
        return "TaskDTO{" +
                "id=" + id +
                ", taskName='" + taskName + '\'' +
                ", description='" + description + '\'' +
                ", createdAt=" + createdAt +
                ", dueDate=" + dueDate +
                ", expectedTime=" + expectedTime +
                ", taskPriorityLevel=" + taskPriorityLevel +
                ", taskStatus=" + taskStatus +
                ", taskCollection=" + taskCollection +
                ", taskLogs=" + taskLogs +
                '}';
    }
}
