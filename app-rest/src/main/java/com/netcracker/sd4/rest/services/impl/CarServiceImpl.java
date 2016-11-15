package com.netcracker.sd4.rest.services.impl;

import com.netcracker.sd4.persistence.dao.CarDao;
import com.netcracker.sd4.persistence.domain.Car;
import com.netcracker.sd4.rest.dto.CarDto;
import com.netcracker.sd4.rest.exceptions.ResourceNotFoundException;
import com.netcracker.sd4.rest.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CarServiceImpl implements CarService {

    private CarDao carDao;
    private ConversionService conversionService;

    private static final TypeDescriptor carDescriptor =
            TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(Car.class));
    private static final TypeDescriptor carDtoDescriptor =
            TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(CarDto.class));

    @Value("${controllers.car.errors.not.found}")
    private String CARS_NOT_FOUND_MESSAGE;

    @Autowired
    public void setCarDao(CarDao carDao) {
        this.carDao = carDao;
    }

    @Autowired
    public void setConversionService(ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    public CarDto addCar(CarDto carDto) {
        Car car = conversionService.convert(carDto, Car.class);
        carDao.add(car);
        return carDto;
    }

    @Override
    public CarDto updateCar(String model, CarDto carDto) {
        Car car = carDao.getCarByModel(model);
        if (car == null) {
            throw new ResourceNotFoundException(CARS_NOT_FOUND_MESSAGE);
        }
        car.setModel(carDto.getModel());
        car.setManufacturer(carDto.getManufacturer());
        car.setPrice(carDto.getPrice());
        car.setAmountLeft(carDto.getAmountLeft());
        car.setBodyStyle(carDto.getBodyStyle());
        car.setProductionYear(carDto.getProductionYear());
        carDao.update(car);
        return carDto;
    }

    @Override
    public void deleteCar(String model) {
        Car car = carDao.getCarByModel(model);
        if (car == null) {
            throw new ResourceNotFoundException(CARS_NOT_FOUND_MESSAGE);
        } else {
            carDao.delete(car);
        }
    }

    @Override
    public List<CarDto> getAllCars() {
        List<Car> cars = carDao.getAll(Car.class);

        @SuppressWarnings("unchecked")
        List<CarDto> result = (List<CarDto>) conversionService.convert(cars, carDescriptor, carDtoDescriptor);
        if (CollectionUtils.isEmpty(result)) {
            throw new ResourceNotFoundException(CARS_NOT_FOUND_MESSAGE);
        }
        return result;
    }
}
