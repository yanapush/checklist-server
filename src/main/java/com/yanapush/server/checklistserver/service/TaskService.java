package com.yanapush.server.checklistserver.service;

import com.yanapush.server.checklistserver.entity.MadeTask;
import com.yanapush.server.checklistserver.entity.Role;
import com.yanapush.server.checklistserver.entity.Task;
import com.yanapush.server.checklistserver.entity.User;

import java.util.List;

public interface TaskService {
    public List<Task> getAllTasks();

    public Task getTask(int id);

    public List<Task> getTasksByRole(Role role);

    public void addTask(Task task);

    public void deleteTask(int id);
}
