package com.yanapush.server.checklistserver.controller;

import com.yanapush.server.checklistserver.entity.MadeTask;
import com.yanapush.server.checklistserver.entity.Role;
import com.yanapush.server.checklistserver.entity.Task;
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

    @GetMapping("/made/{userid}")
    public List<MadeTask> showUsersMadeTasks(@PathVariable int userid) {
        return service.getMadeTasksByUser(userid);
    }

    @PostMapping("/made")
    public void addMadeTask(@RequestBody MadeTask task) {
        service.addMadeTask(task);
    }
//
//    @DeleteMapping("/made/{id}")
//    public void deleteTask(@PathVariable int id) {
//        service.deleteTask(id);
//    }
}
