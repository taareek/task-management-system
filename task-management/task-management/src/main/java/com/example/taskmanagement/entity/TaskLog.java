package com.example.taskmanagement.entity;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "task_log_table_3")
public class TaskLog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "spent_time")
    private Double spentTime;
    @Lob
    @Type(type = "org.hibernate.type.TextType")
    @Column(name="log_note")
    private String logNote;

    @Column(name= "log_date")
    private Instant logDate;

    // a task log must belong to a specific task
    @ManyToOne
    @JoinColumn(name = "task_id", nullable = false, referencedColumnName = "id")
    private Task task;

    public TaskLog() {}

    public TaskLog(Long id, Double spentTime, String logNote, Instant logDate, Task task) {
        this.id = id;
        this.spentTime = spentTime;
        this.logNote = logNote;
        this.logDate = logDate;
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

    public Instant getLogDate() {
        return logDate;
    }

    public void setLogDate(Instant logDate) {
        this.logDate = logDate;
    }

    @Override
    public String toString() {
        return "TaskLog{" +
                "id=" + id +
                ", spentTime=" + spentTime +
                ", logNote='" + logNote + '\'' +
                ", logDate=" + logDate +
                ", task=" + task +
                '}';
    }
}
