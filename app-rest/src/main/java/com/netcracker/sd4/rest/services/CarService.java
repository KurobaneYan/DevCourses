package com.netcracker.sd4.rest.services;

import com.netcracker.sd4.rest.dto.CarDto;

import java.util.List;

public interface CarService {
    List<CarDto> getAllCars();
    List<CarDto> getCarsForPage(int page, int pageSize);
    CarDto addCar(CarDto carDto);
    CarDto updateCar(String model, CarDto carDto);
    void deleteCar(String model);
}
