package com.netcracker.sd4.rest.converters;

import com.netcracker.sd4.persistence.domain.CarInOrder;
import com.netcracker.sd4.rest.dto.CarInOrderDto;
import org.springframework.core.convert.converter.Converter;

public class CarInOrderToCarInOrderDtoConverter implements Converter<CarInOrder, CarInOrderDto> {
    @Override
    public CarInOrderDto convert(CarInOrder carInOrder) {
        CarInOrderDto carInOrderDto = new CarInOrderDto();
        carInOrderDto.setAmount(carInOrder.getAmount());
        return carInOrderDto;
    }
}
