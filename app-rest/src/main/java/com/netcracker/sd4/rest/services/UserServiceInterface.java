package com.netcracker.sd4.rest.services;

import com.netcracker.sd4.persistence.domain.User;
import com.netcracker.sd4.rest.dto.UserDto;

import java.util.List;

public interface UserServiceInterface {
    List<UserDto> getAllUsers();
}
