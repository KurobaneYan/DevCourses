package com.netcracker.sd4.persistence.api.dao.impl;

import com.netcracker.sd4.persistence.api.dao.UserDaoIntefrace;
import com.netcracker.sd4.persistence.domain.User;
import com.netcracker.sd4.persistence.domain.User_;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class UserDao extends AbstractDao implements UserDaoIntefrace{

    @Override
    public User getUser(String name, String surname) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
        Root<User> from = criteriaQuery.from(User.class);
        criteriaQuery.where(criteriaBuilder.equal(from.get(User_.name), name));
        criteriaQuery.where(criteriaBuilder.equal(from.get(User_.surname), surname));
        criteriaQuery.select(from);
        return entityManager.createQuery(criteriaQuery).getSingleResult();
    }

    @Override
    public User getUserByEmail(String email) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
        Root<User> from = criteriaQuery.from(User.class);
        criteriaQuery.where(criteriaBuilder.equal(from.get(User_.email), email));
        criteriaQuery.select(from);
        return entityManager.createQuery(criteriaQuery).getSingleResult();
    }
}
