package com.netcracker.sd4.rest.services;

import com.netcracker.sd4.rest.dto.OrderDto;
import com.netcracker.sd4.rest.dto.RoleDto;
import com.netcracker.sd4.rest.dto.UserDto;

import java.util.List;

public interface UserService {
    UserDto addUser(UserDto userDto);
    UserDto updateUser(String name, String surname, UserDto userDto);
    void deleteUser(UserDto userDto);
    List<UserDto> getAllUsers();
    List<RoleDto> getUserRoles(UserDto userDto);
    List<OrderDto> getUserOrders(UserDto userDto);
}
