package com.example.taskmanagement.repo;

import com.example.taskmanagement.entity.TaskLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskLogRepo extends JpaRepository<TaskLog, Long> {
}
