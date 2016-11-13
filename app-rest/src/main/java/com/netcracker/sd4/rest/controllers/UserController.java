package com.netcracker.sd4.rest.controllers;

import com.netcracker.sd4.rest.dto.RoleDto;
import com.netcracker.sd4.rest.dto.UserDto;
import com.netcracker.sd4.rest.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UserDto> getAllUsers() {
        return userService.getAllUsers();
    }


    @RequestMapping(value = "/roles" ,method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.CREATED)
    public List<RoleDto> getAllRoles(@RequestBody UserDto user) {
        return userService.getUserRoles(user);
    }
}
