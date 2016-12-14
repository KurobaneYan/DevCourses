package com.netcracker.sd4.persistence.dao;

import java.util.List;

public interface GenericDao {
    <T> List<T> getAll(Class<T> tClass);
    void add(Object o);
    void update(Object o);
    void delete(Object o);
    <T> T get(Class<T> clazz, Object id);
    <T> Number count(Class<T> tClass);
}
