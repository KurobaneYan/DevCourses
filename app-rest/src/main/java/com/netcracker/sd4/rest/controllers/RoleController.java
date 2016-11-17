package com.netcracker.sd4.rest.controllers;

import com.netcracker.sd4.rest.dto.RoleDto;
import com.netcracker.sd4.rest.dto.UserDto;
import com.netcracker.sd4.rest.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleController {
    private RoleService roleService;

    @Autowired
    public void setRoleService(RoleService roleService) {
        this.roleService = roleService;
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(code = HttpStatus.CREATED)
    public RoleDto CreateRole(@RequestBody RoleDto roleDto) {
        return roleService.addRole(roleDto);
    }

    @RequestMapping(value = "/{name}", method = RequestMethod.PUT)
    public RoleDto updateRole(@PathVariable String  name, @RequestBody RoleDto roleDto) {
        return roleService.updateRole(name, roleDto);
    }

    @RequestMapping(value = "/delete/{name}")
    public void deleteRole(@PathVariable String name) {
        roleService.deleteRole(name);
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<RoleDto> getAllRoles() {
        return roleService.getAllRoles();
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public List<UserDto> getAllUsersByRole(@RequestBody RoleDto roleDto) {
        return roleService.getAllUsersByRole(roleDto);
    }
}
