package com.netcracker.sd4.persistence.api.dao;

import com.netcracker.sd4.persistence.domain.Car;

import java.util.List;

public interface CarDaoInterface extends BaseDao {
    Car getCar(String model);
    void addCar(Car car);
    void updateCar(Car car);
    void deleteCar(Car car);
    List<Car> getAllCars();
}
