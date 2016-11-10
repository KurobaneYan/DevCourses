package com.netcracker.sd4.rest.converters;

import com.netcracker.sd4.persistence.domain.Order;
import com.netcracker.sd4.rest.dto.OrderDto;
import org.springframework.core.convert.converter.Converter;

public class OrderToOrderDtoConverter implements Converter<Order, OrderDto> {
    @Override
    public OrderDto convert(Order order) {
        OrderDto orderDto = new OrderDto();
        orderDto.setCast(order.getCast());
        orderDto.setDate(order.getDate());
        return orderDto;
    }
}
