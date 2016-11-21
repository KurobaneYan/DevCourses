package com.netcracker.sd4.persistence.dao;

import com.netcracker.sd4.persistence.domain.Car;

import java.util.List;

public interface CarDao extends GenericDao {
    Car getCarByModel(String model);
    List<Car> getCarsForPage(int page, int pageSize);
}
