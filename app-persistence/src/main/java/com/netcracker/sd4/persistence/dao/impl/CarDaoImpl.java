package com.netcracker.sd4.persistence.dao.impl;

import com.netcracker.sd4.persistence.dao.CarDao;
import com.netcracker.sd4.persistence.domain.Car;
import com.netcracker.sd4.persistence.domain.Car_;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
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
        return entityManager.createQuery(criteriaQuery).setFirstResult((page - 1) * pageSize).setMaxResults(pageSize).getResultList();
    }

    @Override
    public List<Car> searchCarWithPagination(String keyword, int page, int pageSize) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Car> criteriaQuery = criteriaBuilder.createQuery(Car.class);
        Root<Car> from = criteriaQuery.from(Car.class);
        Predicate model = criteriaBuilder.equal(from.get(Car_.model), keyword);
        Predicate manufacturer = criteriaBuilder.equal(from.get(Car_.manufacturer), keyword);
        Predicate style = criteriaBuilder.equal(from.get(Car_.bodyStyle), keyword);
        criteriaQuery.where(criteriaBuilder.or(model, manufacturer, style));
        criteriaQuery.select(from);
        TypedQuery<Car> query = entityManager.createQuery(criteriaQuery)
                .setFirstResult((page - 1) * pageSize).setMaxResults(pageSize);
        return query.getResultList();
    }

    @Override
    public long countCars() {
        return count(Car.class).longValue();
    }
}
