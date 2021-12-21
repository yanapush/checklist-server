package com.yanapush.server.checklistserver.entity;

import javax.persistence.*;

@Entity
@Table
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "made_today")
    private boolean made_today = false;
    @Column(unique = true)
    private int password;
    @ManyToOne
    @JoinColumn(name = "role", referencedColumnName = "id")
    private Role role;

    public User() {}

    public User(int password, Role role) {
        this.password = password;
        this.role = role;
        this.made_today = false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public boolean isMade_today() {
        return made_today;
    }

    public void setMade_today(boolean made_today) {
        this.made_today = made_today;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", made_today=" + made_today +
                ", password=" + password +
                ", role=" + role +
                '}';
    }
}
