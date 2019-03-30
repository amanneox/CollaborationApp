package com.collaborate.app.collaborateApp.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "project_list")
public class ProjectModel extends AuditModel {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @NotBlank
    @Size(min = 3, max = 100)
    private String name;

    @ElementCollection
    @JsonProperty("users")
    private List<Integer> users;

    public String getName() {
        return name;
    }

    public List<Integer> getUsers() {
        return users;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUsers(List<Integer> users) {
        this.users = users;
    }
}
