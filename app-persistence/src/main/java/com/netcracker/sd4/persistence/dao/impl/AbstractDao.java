package com.netcracker.sd4.persistence.dao.impl;

import com.netcracker.sd4.persistence.dao.GenericDao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public abstract class AbstractDao implements GenericDao {

    @PersistenceContext
    protected EntityManager entityManager;

    @Override
    public <T> List<T> getAll(Class<T> clazz) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(clazz);
        Root<? extends T> from = criteriaQuery.from(clazz);
        criteriaQuery.select(from);
        TypedQuery<T> query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }

    @Override
    public void add(Object o) {
        entityManager.persist(o);
    }

    @Override
    public void update(Object o) {
        entityManager.merge(o);
    }

    @Override
    public void delete(Object o) {
        entityManager.remove(o);
    }

    @Override
    public <T> T get(Class<T> clazz, Object id) {
        return entityManager.find(clazz, id);
    }
}
