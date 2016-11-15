package com.netcracker.sd4.rest.services.impl;

import com.netcracker.sd4.persistence.dao.UserDao;
import com.netcracker.sd4.persistence.domain.Order;
import com.netcracker.sd4.persistence.domain.Role;
import com.netcracker.sd4.persistence.domain.User;
import com.netcracker.sd4.rest.dto.OrderDto;
import com.netcracker.sd4.rest.dto.RoleDto;
import com.netcracker.sd4.rest.dto.UserDto;
import com.netcracker.sd4.rest.exceptions.ResourceNotFoundException;
import com.netcracker.sd4.rest.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
@Transactional
@SuppressWarnings("unchecked")
public class UserServiceImpl implements UserService {
    private UserDao userDao;
    private ConversionService conversionService;

    private static final TypeDescriptor userDescriptor =
            TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(User.class));
    private static final TypeDescriptor userDtoDescriptor =
            TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(UserDto.class));
    private static final TypeDescriptor roleDescriptor =
            TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(Role.class));
    private static final TypeDescriptor roleDtoDescriptor =
            TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(RoleDto.class));
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
    public UserDto addUser(UserDto userDto) {
        User user = conversionService.convert(userDto, User.class);
        userDao.add(user);
        return userDto;
    }

    @Override
    public UserDto updateUser(String name, String surname, UserDto userDto) {
        User user = userDao.getUser(name, surname);
        if (user == null) {
            throw new ResourceNotFoundException(USERS_NOT_FOUND_MESSAGE);
        }
        user.setName(userDto.getName());
        user.setSurname(userDto.getSurname());
        user.setEmail(userDto.getEmail());
        user.setPhoneNumber(userDto.getPhoneNumber());
        user.setPassword(userDto.getPassword());
        userDao.update(user);
        return userDto;
    }

    @Override
    public void deleteUser(UserDto userDto) {
        User user = userDao.getUser(userDto.getName(), userDto.getSurname());
        if (user == null) {
            throw new ResourceNotFoundException(USERS_NOT_FOUND_MESSAGE);
        } else {
            userDao.delete(user);
        }
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> cars = userDao.getAll(User.class);
        List<UserDto> result = (List<UserDto>) conversionService.convert(cars, userDescriptor, userDtoDescriptor);
        if (CollectionUtils.isEmpty(result)) {
            throw new ResourceNotFoundException(USERS_NOT_FOUND_MESSAGE);
        }
        return result;
    }

    @Override

    public List<RoleDto> getUserRoles(UserDto userDto) {
        User user = userDao.getUser(userDto.getName(), userDto.getSurname());
        List<Role> roles =  user.getRoles();
        List<RoleDto> result = (List<RoleDto>) conversionService.convert(roles, roleDescriptor, roleDtoDescriptor);
        if (CollectionUtils.isEmpty(result)) {
            throw new ResourceNotFoundException(ROLES_NOT_FOUND_MESSAGE);
        }
        return result;
    }

    @Override
    public List<OrderDto> getUserOrders(UserDto userDto) {
        User user = userDao.getUser(userDto.getName(), userDto.getSurname());
        List<Order> orders = user.getOrders();
        List<OrderDto> result = (List<OrderDto>) conversionService.convert(orders, orderDescriptor, orderDtoDescriptor);
        if (CollectionUtils.isEmpty(result)) {
            throw new ResourceNotFoundException(ORDERS_NOT_FOUND_MESSAGE);
        }
        return result;
    }


}
