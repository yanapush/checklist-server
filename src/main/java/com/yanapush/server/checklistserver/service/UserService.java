package com.yanapush.server.checklistserver.service;


import com.yanapush.server.checklistserver.entity.Role;
import com.yanapush.server.checklistserver.entity.User;

import java.util.List;

public interface UserService {
    public List<User> getAllUsers();

    public User getUser(int id);

    public User getUserByPassword(int password);

    public List<User> getUsersByRole(int role);

    public void addUser(int password, int role, boolean made_today);

    public void deleteUser(int id);
}
