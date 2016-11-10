package com.netcracker.sd4.persistence.api.dao;

import com.netcracker.sd4.persistence.domain.Car;

import java.util.List;

public interface CarDaoInterface extends BaseDao {
    Car getCarByModel(String model);
}
