package com.netcracker.sd4.rest.services.impl;

import com.netcracker.sd4.persistence.api.dao.impl.CarDao;
import com.netcracker.sd4.persistence.domain.Car;
import com.netcracker.sd4.rest.dto.CarDto;
import com.netcracker.sd4.rest.exceptions.ResourceNotFoundException;
import com.netcracker.sd4.rest.services.CarServiceInterface;
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
public class CarService implements CarServiceInterface {

    private CarDao carDao;
    private ConversionService conversionService;

    private static final TypeDescriptor carDescriptor =
            TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(Car.class));
    private static final TypeDescriptor carDtoDescriptor =
            TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(CarDto.class));

    @Value("${controllers.car.errors.not.found}")
    private String NOT_FOUND_MESSAGE;

    @Autowired
    public void setCarDao(CarDao carDao) {
        this.carDao = carDao;
    }

    @Autowired
    public void setConversionService(ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    public List<CarDto> getAllCars() {
        List<Car> cars = carDao.getAll(Car.class);
        System.out.println(cars);

        @SuppressWarnings("unchecked")
        List<CarDto> result = (List<CarDto>) conversionService.convert(cars, carDescriptor, carDtoDescriptor);
        if (CollectionUtils.isEmpty(result)) {
            throw new ResourceNotFoundException(NOT_FOUND_MESSAGE);
        }
        return result;
    }

    @Override
    public CarDto addCar(CarDto carDto) {
        Car car = conversionService.convert(carDto, Car.class);
        //Car car = (Car)conversionService.convert(carDto, carDtoDescriptor, carDescriptor);
        carDao.add(car);
        return carDto;
    }
}
