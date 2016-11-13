package com.netcracker.sd4.persistence.dao;

import com.netcracker.sd4.persistence.domain.Car;

public interface CarDao extends GenericDao {
    Car getCarByModel(String model);
}
