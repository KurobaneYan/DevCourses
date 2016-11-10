package com.netcracker.sd4.rest.services;

import com.netcracker.sd4.persistence.domain.Car;
import com.netcracker.sd4.rest.dto.CarDto;

import java.util.List;

public interface CarServiceInterface {
    List<CarDto> getAllCars();
    CarDto addCar(CarDto car);
}
