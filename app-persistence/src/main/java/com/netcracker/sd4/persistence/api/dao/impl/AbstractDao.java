package com.netcracker.sd4.persistence.api.dao.impl;

import com.netcracker.sd4.persistence.api.dao.BaseDao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Objects;

public abstract class AbstractDao implements BaseDao {

    @PersistenceContext
    protected EntityManager entityManager;

    @Override
    public <T> List<T> getAllEntities(Class<T> clazz) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(clazz);
        Root<? extends T> from = criteriaQuery.from(clazz);
        criteriaQuery.select(from);
        TypedQuery<T> query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }

    @Override
    public <T> T getEntity(Class<T> clazz, Object id) {
        return entityManager.find(clazz, id);
    }
}
