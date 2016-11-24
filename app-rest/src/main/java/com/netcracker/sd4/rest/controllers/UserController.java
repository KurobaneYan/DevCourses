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
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UserDto> getAllUsers() {
        return userService.getAllUsers();
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseStatus(code = HttpStatus.CREATED)
    public UserDto createUser(@RequestBody UserDto userDto) {
        return userService.addUser(userDto);
    }

    @RequestMapping(value = "/{surname}/{name}", method = RequestMethod.PUT)
    public UserDto updateUser(@PathVariable("name") String name, @PathVariable("surname") String surname, @RequestBody UserDto userDto) {
        return userService.updateUser(name, surname, userDto);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public void deleteUser(@RequestBody UserDto userDto) {
        userService.deleteUser(userDto);
    }

    @RequestMapping(value = "/roles" , method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<RoleDto> getUserRoles(@RequestBody UserDto userDto) {
        return userService.getUserRoles(userDto);
    }
}
