package com.collaborate.app.collaborateApp.controller;

import com.collaborate.app.collaborateApp.model.ProjectModel;
import com.collaborate.app.collaborateApp.model.TaskModel;
import com.collaborate.app.collaborateApp.repository.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TaskController {

    @Autowired
    private TaskRepo taskRepo;

    @GetMapping("/task")
    public Page<TaskModel> getTasks(Pageable pageable) {
        return taskRepo.findAll(pageable);
    }


    @GetMapping("/task/{taskId}")
    public Optional<TaskModel> getTaskById(@PathVariable Long taskId) {
        return taskRepo.findById(taskId);
    }

}
