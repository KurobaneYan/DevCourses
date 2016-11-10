package com.netcracker.sd4.rest.converters;

import com.netcracker.sd4.persistence.domain.Role;
import com.netcracker.sd4.rest.dto.RoleDto;
import org.springframework.core.convert.converter.Converter;

public class RoleToRoleDtoConverter implements Converter<RoleDto, Role> {
    @Override
    public Role convert(RoleDto roleDto) {
        Role role = new Role();
        role.setName(roleDto.getName());
        role.setAdmin(roleDto.getAdmin());
        return role;
    }
}
