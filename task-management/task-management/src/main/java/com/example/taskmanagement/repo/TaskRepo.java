package com.example.taskmanagement.repo;

import com.example.taskmanagement.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepo extends JpaRepository<Task, Long> {
//    @Query
//    "select * from tasks order by created_at desc";
//    List<Task> getAllTasks();
//    here write a query that will sort by date and last entry will be shown iat first
}
