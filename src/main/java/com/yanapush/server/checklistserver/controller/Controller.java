package com.yanapush.server.checklistserver.controller;

import com.yanapush.server.checklistserver.entity.MadeTask;
import com.yanapush.server.checklistserver.entity.Role;
import com.yanapush.server.checklistserver.entity.Task;
import com.yanapush.server.checklistserver.entity.User;
import com.yanapush.server.checklistserver.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class Controller {

    @Autowired
    private Service service;

    @RequestMapping("/")
    @ResponseBody
    String home() {
        return "Hello World!";
    }

    @GetMapping("/tasks/{userid}")
    public List<Task> showUsersTask(@PathVariable int userid) {
        return service.getTasksByRole(service.getUser(userid).getRole());
    }

    @GetMapping("/roles/{role_id}")
    public Role showRole(@PathVariable int role_id) {
        return service.getRole(role_id);
    }

    @GetMapping("/user/{id}")
    public User showUser(@PathVariable int id) {
        return service.getUser(id);
    }

    @GetMapping("/{password}")
    public User showUserByPassword(@PathVariable int password) {
        return service.getUserByPassword(password);
    }

    @GetMapping("/roles")
    public List<Role> showRoles() {
        return service.getAllRoles();
    }

    @PostMapping("/tasks")
    public void addTask(@RequestBody Task task) {
        service.addTask(task);
    }

    @DeleteMapping("/tasks/{id}")
    public void deleteTask(@PathVariable int id) {
        service.deleteTask(id);
    }

    @GetMapping("/made")
    public List<MadeTask> showMadeTasks() {
        return service.getAllMadeTasks();
    }

    @GetMapping("/made/{roleid}/{date}")
    public List<MadeTask> showRolesMadeTasks(@PathVariable int roleid, @PathVariable String date) {
        System.out.println(date);
        return service.getMadeTasksByRole(roleid, date);
    }

    @PostMapping("/made")
    public void addMadeTask(@RequestBody MadeTask task) {
        service.addMadeTask(task);
    }

    @PostMapping("/all_made/{user_id}")
    public void addMadeTasks(@RequestBody List<Task> tasks, @PathVariable int user_id) {
        service.addUser(service.getUser(user_id).getPassword(), service.getUser(user_id).getRole().getId(), true);
        service.addMadeTasks(tasks, user_id);
    }


    //
//    @DeleteMapping("/made/{id}")
//    public void deleteTask(@PathVariable int id) {
//        service.deleteTask(id);
//    }
}
