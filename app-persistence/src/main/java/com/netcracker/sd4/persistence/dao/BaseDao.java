package com.netcracker.sd4.persistence.dao;

import java.util.List;

public interface BaseDao {
    <T> List<T> getAll(Class<T> clazz);
    void add(Object o);
    void update(Object o);
    void delete(Object o);
    <T> T get(Class<T> clazz, Object id);
}
