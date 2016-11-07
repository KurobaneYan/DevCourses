package com.netcracker.sd4.persistence.api.dao;

import java.util.List;

public interface BaseDao {
    <T> List<T> getAllEntities(Class<T> clazz);

    <T> T getEntity(Class<T> clazz, Object id);
}
