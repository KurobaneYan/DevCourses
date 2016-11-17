package com.netcracker.sd4.rest.services;

import com.netcracker.sd4.rest.dto.RoleDto;
import com.netcracker.sd4.rest.dto.UserDto;

import java.util.List;

public interface RoleService {
    RoleDto addRole(RoleDto roleDto);
    RoleDto updateRole(String name, RoleDto roleDto);
    void deleteRole(String name);
    List<RoleDto> getAllRoles();
    List<UserDto> getAllUsersByRole(RoleDto roleDto);
}
