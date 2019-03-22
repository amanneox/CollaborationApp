package com.collaborate.app.collaborateApp.controller;

import com.collaborate.app.collaborateApp.model.ProjectModel;
import com.collaborate.app.collaborateApp.repository.ProjectRepo;
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
public class ProjectController {
    @Autowired
    private ProjectRepo projectRepo;

    @GetMapping("/project")
    public Page<ProjectModel> getProjects(Pageable pageable) {
        return projectRepo.findAll(pageable);
    }


    @GetMapping("/project/{ProjectId}")
    public Optional<ProjectModel> getProjectById(@PathVariable Long projectId) {
        return projectRepo.findById(projectId);
    }


}
