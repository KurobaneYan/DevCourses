package com.netcracker.sd4.rest.converters;

import com.netcracker.sd4.persistence.domain.Car;
import com.netcracker.sd4.rest.dto.CarDto;
import org.springframework.core.convert.converter.Converter;

public class CarToCarDtoConverter implements Converter<Car, CarDto> {
    @Override
    public CarDto convert(Car car) {
        CarDto dto = new CarDto();
        dto.setId(car.getId());
        dto.setModel(car.getModel());
        dto.setManufacturer(car.getManufacturer());
        dto.setAmountLeft(car.getAmountLeft());
        dto.setBodyStyle(car.getBodyStyle());
        dto.setPrice(car.getPrice());
        dto.setProductionYear(car.getProductionYear());
        return dto;
    }
}
