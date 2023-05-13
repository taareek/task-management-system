package com.example.taskmanagement.dto;

import com.example.taskmanagement.entity.Task;

public class TaskLogDTO {
    private Long id;
    private Double spentTime;
    private String logNote;
    private Task task;

    public TaskLogDTO() {}

    public TaskLogDTO(Long id, Double spentTime, String logNote, Task task) {
        this.id = id;
        this.spentTime = spentTime;
        this.logNote = logNote;
        this.task = task;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getSpentTime() {
        return spentTime;
    }

    public void setSpentTime(Double spentTime) {
        this.spentTime = spentTime;
    }

    public String getLogNote() {
        return logNote;
    }

    public void setLogNote(String logNote) {
        this.logNote = logNote;
    }
    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }


    @Override
    public String toString() {
        return "TaskLogDTO{" +
                "id=" + id +
                ", spentTime=" + spentTime +
                ", logNote='" + logNote + '\'' +
                '}';
    }
}
