package com.netcracker.sd4.rest.services.impl;

import com.netcracker.sd4.persistence.dao.impl.UserDaoImpl;
import com.netcracker.sd4.persistence.domain.User;
import com.netcracker.sd4.rest.dto.UserDto;
import com.netcracker.sd4.rest.exceptions.ResourceNotFoundException;
import com.netcracker.sd4.rest.services.UserService;
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
public class UserServiceImpl implements UserService {
    private UserDaoImpl userDaoImpl;
    private ConversionService conversionService;

    private static final TypeDescriptor userDescriptor =
            TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(User.class));
    private static final TypeDescriptor userDtoDescriptor =
            TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(UserDto.class));

    @Value("${controllers.car.errors.not.found}")
    private String NOT_FOUND_MESSAGE;

    @Autowired
    public void setCarDao(UserDaoImpl userDaoImpl) {
        this.userDaoImpl = userDaoImpl;
    }

    @Autowired
    public void setConversionService(ConversionService conversionService) {
        this.conversionService = conversionService;
    }
    @Override
    public List<UserDto> getAllUsers() {
        List<User> cars = userDaoImpl.getAll(User.class);

        @SuppressWarnings("unchecked")
        List<UserDto> result = (List<UserDto>) conversionService.convert(cars, userDescriptor, userDtoDescriptor);
        if (CollectionUtils.isEmpty(result)) {
            throw new ResourceNotFoundException(NOT_FOUND_MESSAGE);
        }
        return result;
    }
}
