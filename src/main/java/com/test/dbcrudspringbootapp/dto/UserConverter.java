package com.test.dbcrudspringbootapp.dto;

import com.test.dbcrudspringbootapp.entity.User;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class UserConverter {

    private final ModelMapper modelMapper;

    public UserDto convert(User user) {
        return modelMapper.map(user, UserDto.class);
    }

    public User convert(CreateUserRequest createUserRequest) {
        return modelMapper.map(createUserRequest, User.class);
    }
}
