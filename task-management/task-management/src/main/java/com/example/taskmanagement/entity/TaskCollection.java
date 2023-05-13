package com.example.taskmanagement.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="taskCollection")
public class TaskCollection {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name="task_cln_name")
    private String taskCollectionName;

    // a task collection may have one or more tasks
    @OneToMany(mappedBy = "taskCollection", cascade = CascadeType.ALL)
    private List<Task> tasks;

    public TaskCollection() {}

    public TaskCollection(Long id, String taskCollectionName, List<Task> tasks) {
        this.id = id;
        this.taskCollectionName = taskCollectionName;
        this.tasks = tasks;
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

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    @Override
    public String toString() {
        return "TaskCollection{" +
                "id=" + id +
                ", taskCollectionName='" + taskCollectionName + '\'' +
                ", tasks=" + tasks +
                '}';
    }
}
