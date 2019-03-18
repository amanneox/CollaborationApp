package com.collaborate.app.collaborateApp.repository;

import com.collaborate.app.collaborateApp.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface UserRepo extends JpaRepository<UserModel, Long> {
    UserModel findByEmail(String email);

}