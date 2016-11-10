package com.netcracker.sd4.rest.controllers;

import com.netcracker.sd4.rest.dto.UserDto;
import com.netcracker.sd4.rest.services.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserServiceInterface userService;

    @Autowired
    public void setUserService(UserServiceInterface userService) {
        this.userService = userService;
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UserDto> getAllUsers() {
        return userService.getAllUsers();
    }
}
