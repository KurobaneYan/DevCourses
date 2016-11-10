package com.netcracker.sd4.rest.converters;

import com.netcracker.sd4.persistence.domain.Role;
import com.netcracker.sd4.rest.dto.RoleDto;
import org.springframework.core.convert.converter.Converter;

public class RoleDtoToRoleConverter implements Converter<Role, RoleDto> {
    @Override
    public RoleDto convert(Role role) {
        RoleDto roleDto = new RoleDto();
        roleDto.setName(role.getName());
        roleDto.setAdmin(role.getAdmin());
        return roleDto;
    }
}
