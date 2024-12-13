package com.example.gestiontask.Repository;

import com.example.gestiontask.Model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
