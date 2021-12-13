package com.yanapush.server.checklistserver.service;

import com.yanapush.server.checklistserver.dao.MadeTaskRepository;
import com.yanapush.server.checklistserver.dao.RoleRepository;
import com.yanapush.server.checklistserver.dao.TaskRepository;
import com.yanapush.server.checklistserver.dao.UserRepository;
import com.yanapush.server.checklistserver.entity.MadeTask;
import com.yanapush.server.checklistserver.entity.Role;
import com.yanapush.server.checklistserver.entity.Task;
import com.yanapush.server.checklistserver.entity.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Service
public class Service implements MadeTaskService, TaskService, RoleService, UserService{
    @Autowired
    private MadeTaskRepository madeTaskRepository;

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<MadeTask> getAllMadeTasks() {
        return madeTaskRepository.findAll();
    }

    @Override
    public MadeTask getMadeTask(int id, String date) {
        return madeTaskRepository.findMadeTaskByDateAndId(date, id);
    }

    @Override
    public List<MadeTask> getMadeTasksByRole(int role) {
        return madeTaskRepository.findAllByUserIn(userRepository.getByRole(roleRepository.getById(role)));
    }

    @Override
    public List<MadeTask> getMadeTasksByUser(int user) {
        return madeTaskRepository.findAllByUser(userRepository.getById(user));
    }

    @Override
    public List<MadeTask> getMadeTasksByDate(String date) {
        return madeTaskRepository.findAllByDate(date);
    }

    @Override
    public List<MadeTask> getMadeTasksByDateBetween(String lhs, String rhs) {
        return madeTaskRepository.findAllByDateBetween(lhs, rhs);
    }

    @Override
    public void addMadeTask(MadeTask madeTask) {
        java.util.Date dt = new java.util.Date();
        java.text.SimpleDateFormat sdf =
                new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentTime = sdf.format(dt);
        madeTask.setDate(currentTime);
        madeTaskRepository.save(madeTask);
    }

    @Override
    public void deleteMadeTask(int task, String date) {
        madeTaskRepository.delete(madeTaskRepository.findMadeTaskByDateAndId(date, task));
    }

    public void deleteMadeTasksByDate(String date) {
        madeTaskRepository.deleteAllByDate(date);
    }

    @Override
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    @Override
    public Role getRole(int id) {
        return roleRepository.getById(id);
    }

    @Override
    public void addRole(int id, String name) {
        roleRepository.save(new Role(id, name));
    }

    @Override
    public void deleteRole(int id) {
        roleRepository.deleteById(id);
    }

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Task getTask(int id) {
        return taskRepository.getById(id);
    }

    @Override
    public List<Task> getTasksByRole(Role role) {
        return taskRepository.getTaskByRole(role);
    }

    @Override
    public void addTask(Task task) {
        taskRepository.save(task);
    }

    @Override
    public void deleteTask(int id) {
        taskRepository.deleteById(id);
    }

    @Override
    public void addUser(int password, int role) {
        userRepository.save(new User(password, roleRepository.getById(role)));
    }

    @Override
    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(int id) {
        return userRepository.getById(id);
    }

    @Override
    public List<User> getUsersByRole(int role) {
        return userRepository.getByRole(roleRepository.getById(role));
    }
}
