package com.netcracker.sd4.persistence.api.dao;

import com.netcracker.sd4.persistence.domain.User;

import java.util.List;

public interface UserDaoIntefrace extends BaseDao {
    User getUser(String name, String surname);
    User getUserByEmail(String email);
}
