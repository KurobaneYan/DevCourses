package com.netcracker.sd4.rest.services.impl;

import com.netcracker.sd4.persistence.dao.RoleDao;
import com.netcracker.sd4.persistence.domain.Role;
import com.netcracker.sd4.persistence.domain.User;
import com.netcracker.sd4.rest.dto.RoleDto;
import com.netcracker.sd4.rest.dto.UserDto;
import com.netcracker.sd4.rest.exceptions.ResourceNotFoundException;
import com.netcracker.sd4.rest.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {
    private RoleDao roleDao;
    private ConversionService conversionService;

    private static final TypeDescriptor roleDescriptor =
            TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(Role.class));

    private static final TypeDescriptor roleDtoDescriptor =
            TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(RoleDto.class));

    private static final TypeDescriptor userDescriptor =
            TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(User.class));

    private static final TypeDescriptor userDtoDescriptor =
            TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(UserDto.class));

    @Value("${controllers.role.errors.not.found}")
    private String ROLE_NOT_FOUND_MESSAGE;

    @Autowired
    public void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Autowired
    public void setConversionService(ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    public RoleDto addRole(RoleDto roleDto) {
        Role role = conversionService.convert(roleDto, Role.class);
        roleDao.add(role);
        return roleDto;
    }

    @Override
    public RoleDto updateRole(String name, RoleDto roleDto) {
        Role role = roleDao.getRole(name);
        if (role == null) {
            throw new ResourceNotFoundException(ROLE_NOT_FOUND_MESSAGE);
        }
        role.setAdmin(roleDto.getAdmin());
        role.setName(roleDto.getName());
        roleDao.update(role);
        return roleDto;
    }

    @Override
    public void deleteRole(String name) {
        Role role = roleDao.getRole(name);
        if (role == null) {
            throw new ResourceNotFoundException(ROLE_NOT_FOUND_MESSAGE);
        } else {
            roleDao.delete(role);
        }
    }

    @Override
    public List<RoleDto> getAllRoles() {
        List<Role> roles = roleDao.getAll(Role.class);

        @SuppressWarnings("unchecked")
        List<RoleDto> result = (List<RoleDto>) conversionService.convert(roles, roleDescriptor, roleDtoDescriptor);
        if (CollectionUtils.isEmpty(result)) {
            throw new ResourceNotFoundException(ROLE_NOT_FOUND_MESSAGE);
        }
        return result;
    }

    @Override
    public List<UserDto> getAllUsersByRole(RoleDto roleDto) {
        Role role = roleDao.getRole(roleDto.getName());
        if (role == null) {
            throw new ResourceNotFoundException(ROLE_NOT_FOUND_MESSAGE);
        }
        List<User> users = role.getUsers();
        @SuppressWarnings("unchecked")
        List<UserDto> result =(List<UserDto>) conversionService.convert(users, userDescriptor, userDtoDescriptor);
        if (result == null) {
            throw new ResourceNotFoundException(ROLE_NOT_FOUND_MESSAGE);
        }
        return result;
    }


}
