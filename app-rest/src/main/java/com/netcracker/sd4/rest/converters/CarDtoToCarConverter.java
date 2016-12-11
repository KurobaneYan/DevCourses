package com.netcracker.sd4.rest.converters;

import com.netcracker.sd4.persistence.domain.Car;
import com.netcracker.sd4.rest.dto.CarDto;
import org.springframework.core.convert.converter.Converter;

public class CarDtoToCarConverter implements Converter<CarDto, Car> {
    @Override
    public Car convert(CarDto carDto) {
        Car car = new Car();
        car.setId(carDto.getId());
        car.setModel(carDto.getModel());
        car.setManufacturer(carDto.getManufacturer());
        car.setBodyStyle(carDto.getBodyStyle());
        car.setProductionYear(carDto.getProductionYear());
        car.setAmountLeft(carDto.getAmountLeft());
        car.setPrice(carDto.getPrice());
        return car;
    }
}
