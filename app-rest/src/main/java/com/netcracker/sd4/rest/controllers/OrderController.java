package com.netcracker.sd4.rest.controllers;

import com.netcracker.sd4.rest.dto.OrderDto;
import com.netcracker.sd4.rest.dto.UserDto;
import com.netcracker.sd4.rest.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "order")
public class OrderController {
    private OrderService orderService;

    @Autowired
    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<OrderDto> getUserOrders(@RequestBody UserDto userDto) {
        return orderService.getOrders(userDto);
    }

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public OrderDto addNewOrder(@RequestBody UserDto userDto) {
        return orderService.addOrder(userDto);
    }
}
