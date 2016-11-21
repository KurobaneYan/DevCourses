package com.netcracker.sd4.rest.services.impl;

import com.netcracker.sd4.persistence.dao.UserDao;
import com.netcracker.sd4.persistence.domain.Order;
import com.netcracker.sd4.persistence.domain.User;
import com.netcracker.sd4.rest.dto.OrderDto;
import com.netcracker.sd4.rest.dto.UserDto;
import com.netcracker.sd4.rest.exceptions.ResourceNotFoundException;
import com.netcracker.sd4.rest.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;

@Service
@Transactional
@SuppressWarnings("unchecked")
public class OrderServiceImpl implements OrderService {
    private UserDao userDao;
    private ConversionService conversionService;

    private static final TypeDescriptor userDescriptor =
            TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(User.class));
    private static final TypeDescriptor userDtoDescriptor =
            TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(UserDto.class));
    private static final TypeDescriptor orderDescriptor =
            TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(Order.class));
    private static final TypeDescriptor orderDtoDescriptor =
            TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(OrderDto.class));

    @Value("${controllers.user.errors.not.found}")
    private String USERS_NOT_FOUND_MESSAGE;

    @Value("${controllers.role.errors.not.found}")
    private String ROLES_NOT_FOUND_MESSAGE;

    @Value("${controllers.order.errors.not.found}")
    private String ORDERS_NOT_FOUND_MESSAGE;

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Autowired
    public void setConversionService(ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    public List<OrderDto> getOrders(UserDto userDto) {
        User user = userDao.getUser(userDto.getName(), userDto.getSurname());
        List<Order> orders = user.getOrders();
        List<OrderDto> result = (List<OrderDto>) conversionService.convert(orders, orderDescriptor, orderDtoDescriptor);
        if (CollectionUtils.isEmpty(result)) {
            throw new ResourceNotFoundException(ORDERS_NOT_FOUND_MESSAGE);
        }
        return result;
    }

    @Override
    public OrderDto addOrder(UserDto userDto) {
        User user = userDao.getUser(userDto.getName(), userDto.getSurname());
        if (user == null) {
            throw new ResourceNotFoundException(USERS_NOT_FOUND_MESSAGE);
        }
        Order order = new Order();
        order.setUser(user);
        userDao.add(order);
        return conversionService.convert(order, OrderDto.class);
    }

    @Override
    public void checkOrder(int id) {
        Order order = userDao.get(Order.class, id);
        Date date = new Date();
        System.out.print(date);
        order.setDate(date);
    }
}
