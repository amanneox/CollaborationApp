package com.collaborate.app.collaborateApp.repository;

import com.collaborate.app.collaborateApp.model.ProjectModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepo extends JpaRepository<ProjectModel ,Long> {

}
