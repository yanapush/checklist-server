package com.yanapush.server.checklistserver.service;

import com.yanapush.server.checklistserver.entity.Role;
import com.yanapush.server.checklistserver.entity.Task;
import com.yanapush.server.checklistserver.entity.User;

import java.util.List;

public interface RoleService {
    public List<Role> getAllRoles();

    public Role getRole(int id);

    public void addRole(int id, String name);

    public void deleteRole(int id);
}
