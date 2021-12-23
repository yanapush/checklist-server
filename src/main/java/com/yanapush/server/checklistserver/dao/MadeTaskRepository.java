package com.yanapush.server.checklistserver.dao;

import com.yanapush.server.checklistserver.entity.MadeTask;
import com.yanapush.server.checklistserver.entity.MadeTaskId;
import com.yanapush.server.checklistserver.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MadeTaskRepository extends JpaRepository<MadeTask, MadeTaskId> {
    MadeTask findMadeTaskByDateAndId(String date, int id);

    List<MadeTask> findAllByUser(User user);

    List<MadeTask> findAllByDate(String date);

    List<MadeTask> findAllByDateBetween(String lhs,String rhs);

    void deleteAllByDate(String date);

    List<MadeTask> findAllByUserIn(List<User> users);

    List<MadeTask> findAllByUserInAndDateBetween(List<User> user, String date, String date2);
}
