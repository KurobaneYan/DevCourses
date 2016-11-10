package com.netcracker.sd4.persistence.dao;

import com.netcracker.sd4.persistence.domain.Car;

public interface CarDaoInterface extends BaseDao {
    Car getCarByModel(String model);
}
