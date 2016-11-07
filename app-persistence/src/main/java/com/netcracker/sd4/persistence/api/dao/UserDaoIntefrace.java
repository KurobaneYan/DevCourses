package com.netcracker.sd4.persistence.api.dao;

import com.netcracker.sd4.persistence.domain.User;

public interface UserDaoIntefrace extends BaseDao {
    User getUser(String name, String surname);
    void addUser(User user);
    void updateUser(User user);
    void deleteUser(User user);
}
