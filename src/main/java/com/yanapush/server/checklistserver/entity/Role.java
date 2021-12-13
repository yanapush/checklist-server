package com.yanapush.server.checklistserver.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
public class Role {
    @Id
    private int id;
    private String name;

//    @OneToMany(mappedBy="role")
//    private Set<Task> tasks;
//
//    @OneToMany(mappedBy="role")
//    private Set<User> users;

    public Role() {}

    public Role(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public Set<Task> getTasks() {
//        return tasks;
//    }

//    public void setTasks(Set<Task> tasks) {
//        this.tasks = tasks;
//    }

//    public void addTask(Task task) {
//        if (tasks == null) {
//            tasks = new HashSet<Task>();
//        }
//        this.tasks.add(task);
//    }
//
//    public Set<User> getUsers() {
//        return users;
//    }
//
//    public void setUsers(Set<User> users) {
//        this.users = users;
//    }
//
//    public void addUser(User user) {
//        if (users == null) {
//            users = new HashSet<User>();
//        }
//        this.users.add(user);
//    }
}
