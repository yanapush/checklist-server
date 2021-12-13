package com.yanapush.server.checklistserver.entity;

import javax.persistence.*;

@Entity
@Table
@IdClass(MadeTaskId.class)
public class MadeTask {
    @Id
    private int id;

    @ManyToOne
    @JoinColumn(name = "id", referencedColumnName = "id")
    @MapsId
    private Task task;

    @ManyToOne
    @JoinColumn(name = "user", referencedColumnName = "id")
    private User user;

    @Id
    private String date;

    public MadeTask() {}

    public MadeTask(Task task, User user, String date) {
        this.id = task.getId();
        this.task = task;
        this.user = user;
        this.date = date;
    }

    public int getId() {
        return task.getId();
    }

    public void setId(int id) {
        this.id = id;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
