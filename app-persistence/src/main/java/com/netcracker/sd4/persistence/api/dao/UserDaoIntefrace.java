package com.netcracker.sd4.persistence.api.dao;

import com.netcracker.sd4.persistence.domain.User;

import java.util.List;

public interface UserDaoIntefrace extends BaseDao {
    User getUser(String name, String surname);
    void addUser(User user);
    void updateUser(User user);
    void deleteUser(User user);
    List<User> getAllUsers();
}
