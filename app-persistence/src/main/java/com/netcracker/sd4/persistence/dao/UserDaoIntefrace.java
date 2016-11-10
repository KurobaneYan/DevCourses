package com.netcracker.sd4.persistence.dao;

import com.netcracker.sd4.persistence.domain.User;

public interface UserDaoIntefrace extends BaseDao {
    User getUser(String name, String surname);
    User getUserByEmail(String email);
}
