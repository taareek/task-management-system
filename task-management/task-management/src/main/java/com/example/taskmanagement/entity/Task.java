package com.example.taskmanagement.entity;

import com.example.taskmanagement.enums.TaskPriorityLevel;
import com.example.taskmanagement.enums.TaskStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.*;
import java.util.List;

@Entity
@Table(name = "task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name= "task_name")
    private String taskName;
    @Lob
    @Type(type = "org.hibernate.type.TextType")
    @Column(name= "description")
    private String description;
    @Column(name="created_at")
    private Instant createdAt;
    @Column(name="due_date")
//    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate dueDate;
    @Column(name="expected_time")
    private Double expectedTime;
    @Enumerated(EnumType.STRING)
    @Column(name="task_priority_level")
    private TaskPriorityLevel taskPriorityLevel;
    @Enumerated(EnumType.STRING)
    @Column(name="task_status")
    private TaskStatus taskStatus;
    @Column(name="has_reminder")
    private Boolean hasReminder;

    // a task may belong to one task collection
    @ManyToOne
    @JoinColumn(name = "task_cln_id", nullable = true, referencedColumnName = "id")
    private TaskCollection taskCollection;

    // a task will have one to many logs that will be presenting the history of a specific task
    @JsonIgnore
    @OneToMany(mappedBy = "task", cascade = CascadeType.ALL)
    private List<TaskLog> taskLogs;

    public Task() {
    }

    public Task(Long id, String taskName, String description, Instant createdAt, LocalDate dueDate,
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
        return "Task{" +
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
