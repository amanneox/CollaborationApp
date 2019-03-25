package com.collaborate.app.collaborateApp.repository;

import com.collaborate.app.collaborateApp.model.TaskModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepo extends JpaRepository<TaskModel,Long> {
}
