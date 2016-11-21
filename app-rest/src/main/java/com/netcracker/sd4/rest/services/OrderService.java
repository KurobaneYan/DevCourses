package com.netcracker.sd4.rest.services;

import com.netcracker.sd4.rest.dto.OrderDto;
import com.netcracker.sd4.rest.dto.UserDto;

import java.util.List;

public interface OrderService {
    List<OrderDto> getOrders(UserDto userDto);
    OrderDto addOrder(UserDto userDto);
    void checkOrder(int id);
}
