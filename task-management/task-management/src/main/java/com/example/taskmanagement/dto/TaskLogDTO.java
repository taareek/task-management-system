package com.example.taskmanagement.dto;

public class TaskLogDTO {
    private Long id;
    private Double spentTime;
    private String logNote;

    public TaskLogDTO() {}

    public TaskLogDTO(Long id, Double spentTime, String logNote) {
        this.id = id;
        this.spentTime = spentTime;
        this.logNote = logNote;
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

    @Override
    public String toString() {
        return "TaskLogDTO{" +
                "id=" + id +
                ", spentTime=" + spentTime +
                ", logNote='" + logNote + '\'' +
                '}';
    }
}
