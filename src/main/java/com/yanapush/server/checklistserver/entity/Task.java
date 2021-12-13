package com.yanapush.server.checklistserver.entity;

import javax.persistence.*;

@Entity
@Table
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String description;
    @ManyToOne
    @JoinColumn(name = "role", referencedColumnName = "id")
    private Role role;

    public Task() {}

    public Task(String description, Role role) {
        this.description = description;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
