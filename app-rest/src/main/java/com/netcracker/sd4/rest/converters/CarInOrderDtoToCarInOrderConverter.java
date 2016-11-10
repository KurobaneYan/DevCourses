package com.netcracker.sd4.rest.converters;

import com.netcracker.sd4.persistence.domain.CarInOrder;
import com.netcracker.sd4.rest.dto.CarInOrderDto;
import org.springframework.core.convert.converter.Converter;

public class CarInOrderDtoToCarInOrderConverter implements Converter<CarInOrderDto, CarInOrder> {
    @Override
    public CarInOrder convert(CarInOrderDto carInOrderDto) {
        CarInOrder carInOrder = new CarInOrder();
        carInOrder.setAmount(carInOrderDto.getAmount());
        return carInOrder;
    }
}
