package com.netcracker.sd4.persistence.dao.impl;

import com.netcracker.sd4.persistence.dao.RoleDao;
import com.netcracker.sd4.persistence.domain.Role;
import com.netcracker.sd4.persistence.domain.Role_;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

@Repository
public class RoleDaoImpl extends AbstractDao implements RoleDao {
    @Override
    public Role getRole(String name) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Role> criteriaQuery = criteriaBuilder.createQuery(Role.class);
        Root<Role> from = criteriaQuery.from(Role.class);
        criteriaQuery.where(criteriaBuilder.equal(from.get(Role_.name), name));
        criteriaQuery.select(from);
        return entityManager.createQuery(criteriaQuery).getSingleResult();
    }
}
