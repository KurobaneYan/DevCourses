package com.netcracker.sd4.rest.converters;

import com.netcracker.sd4.persistence.domain.Order;
import com.netcracker.sd4.rest.dto.OrderDto;
import org.springframework.core.convert.converter.Converter;

public class OrderDtoToOrderConverter implements Converter<OrderDto, Order> {
    @Override
    public Order convert(OrderDto orderDto) {
        Order order = new Order();
        order.setDate(orderDto.getDate());
        order.setCast(orderDto.getCast());
        return order;
    }
}
