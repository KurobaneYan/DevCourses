package com.netcracker.sd4.persistence.dao;

import com.netcracker.sd4.persistence.domain.Role;

public interface RoleDao extends GenericDao {
    Role getRole(String name);
}
