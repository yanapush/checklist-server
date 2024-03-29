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

import java.sql.DatabaseMetaData;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@org.springframework.stereotype.Service
public class Service implements MadeTaskService, TaskService, RoleService, UserService {
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
    public List<MadeTask> getMadeTasksByRole(int role, String date) {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            cal.setTime(sdf.parse(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        cal.add(Calendar.DAY_OF_MONTH, -1);
        Date dt = cal.getTime();
        String date1 = sdf.format(dt);
        cal.add(Calendar.DAY_OF_MONTH, 2);
        date = sdf.format(cal.getTime());
        System.out.println(date1);
        System.out.println(date);
        List<MadeTask> list = madeTaskRepository.findAllByUserInAndDateBetween(userRepository.findAllByRole(roleRepository.findById(role).get()), date1, date);
        System.out.println(list);
        return list;
    }

    @Override
    public List<MadeTask> getMadeTasksByUser(int user) {
        return madeTaskRepository.findAllByUser(userRepository.findById(user).get());
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
        return roleRepository.findById(id).get();
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
        return taskRepository.findById(id).get();
    }

    @Override
    public List<Task> getTasksByRole(Role role) {
        return taskRepository.findTaskByRole(role);
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
    public void addUser(int password, int role, boolean made_today) {
        User user = userRepository.findByPassword(password);
        System.out.println(user);
        if (made_today) {
            java.util.Date dt = new java.util.Date();
            java.text.SimpleDateFormat sdf =
                    new java.text.SimpleDateFormat("yyyy-MM-dd");
            String currentTime = sdf.format(dt);
            user.setLast_update(currentTime);
        }
        System.out.println(user);
        userRepository.save(user);
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
        return userRepository.findById(id).get();
    }

    @Override
    public List<User> getUsersByRole(int role) {
        return userRepository.findByRole(roleRepository.findById(role).get());
    }

    @Override
    public User getUserByPassword(int password) {
        return userRepository.findByPassword(password);
    }

    public void addMadeTasks(List<Task> tasks, int user_id) {
        java.util.Date dt = new java.util.Date();
        java.text.SimpleDateFormat sdf =
                new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentTime = sdf.format(dt);
        List<MadeTask> madeTasks = new ArrayList<MadeTask>();
        tasks.forEach(task -> madeTasks.add(new MadeTask(task, userRepository.findById(user_id).get(), currentTime)));
        madeTaskRepository.saveAll(madeTasks);
    }
}
