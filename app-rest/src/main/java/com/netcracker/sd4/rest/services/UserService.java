package com.netcracker.sd4.rest.services;

import com.netcracker.sd4.rest.dto.UserDto;

import java.util.List;

public interface UserService {
    List<UserDto> getAllUsers();
}
