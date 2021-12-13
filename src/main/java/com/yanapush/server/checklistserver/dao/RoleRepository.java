package com.yanapush.server.checklistserver.dao;

import com.yanapush.server.checklistserver.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {}
