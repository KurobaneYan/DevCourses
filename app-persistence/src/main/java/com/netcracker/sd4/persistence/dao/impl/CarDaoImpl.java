package com.netcracker.sd4.persistence.dao.impl;

import com.netcracker.sd4.persistence.dao.CarDao;
import com.netcracker.sd4.persistence.domain.Car;
import com.netcracker.sd4.persistence.domain.Car_;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class CarDaoImpl extends AbstractDao implements CarDao {

    @Override
    public Car getCarByModel(String model) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Car> criteriaQuery = criteriaBuilder.createQuery(Car.class);
        Root<Car> from = criteriaQuery.from(Car.class);
        criteriaQuery.where(criteriaBuilder.equal(from.get(Car_.model), model));
        criteriaQuery.select(from);
        return entityManager.createQuery(criteriaQuery).getSingleResult();
    }

    @Override
    public List<Car> getCarsForPage(int page, int pageSize) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Car> criteriaQuery = criteriaBuilder.createQuery(Car.class);
        Root<Car> from = criteriaQuery.from(Car.class);
        criteriaQuery.select(from);
        return entityManager.createQuery(criteriaQuery).setFirstResult(page - 1).setMaxResults(pageSize).getResultList();
    }
}
