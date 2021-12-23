package com.yanapush.server.checklistserver.service;

import com.yanapush.server.checklistserver.entity.MadeTask;
import com.yanapush.server.checklistserver.entity.Role;
import com.yanapush.server.checklistserver.entity.Task;
import com.yanapush.server.checklistserver.entity.User;

import java.util.List;

public interface MadeTaskService {
    public List<MadeTask> getAllMadeTasks();

    public MadeTask getMadeTask(int id, String date);

    public List<MadeTask> getMadeTasksByRole(int role, String date);

    public List<MadeTask> getMadeTasksByUser(int user);

    public List<MadeTask> getMadeTasksByDate(String date);

    public List<MadeTask> getMadeTasksByDateBetween(String lhs, String rhs);

    public void addMadeTask(MadeTask madeTask);

    public void deleteMadeTask(int task, String date);

    public void deleteMadeTasksByDate(String date);
}
