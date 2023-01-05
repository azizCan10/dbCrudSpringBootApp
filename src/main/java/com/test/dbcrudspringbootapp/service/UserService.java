package com.test.dbcrudspringbootapp.service;

import com.test.dbcrudspringbootapp.core.result.DataResult;
import com.test.dbcrudspringbootapp.core.result.Result;
import com.test.dbcrudspringbootapp.core.result.SuccessDataResult;
import com.test.dbcrudspringbootapp.core.result.SuccessResult;
import com.test.dbcrudspringbootapp.dto.CreateUserRequest;
import com.test.dbcrudspringbootapp.dto.UserConverter;
import com.test.dbcrudspringbootapp.dto.UserDto;
import com.test.dbcrudspringbootapp.entity.User;
import com.test.dbcrudspringbootapp.exception.UserNotFoundException;
import com.test.dbcrudspringbootapp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserConverter userConverter;

    public Result add(CreateUserRequest createUserRequest) {
        userRepository.save(userConverter.convert(createUserRequest));
        return new SuccessResult("User added. Name: " + createUserRequest.getName());
    }

    public DataResult<List<UserDto>> getAll() {
        return new SuccessDataResult<>(userRepository.findAll().stream().
                map(userConverter::convert).collect(Collectors.toList()),
                "All users listed.");
    }

    public DataResult<UserDto> getById(long id) {
        return new SuccessDataResult<>(userConverter.convert(findUserById(id)), "User listed.");
    }

    public Result delete(long id) {
        findUserById(id);

        userRepository.deleteById(id);
        return new SuccessResult(id + ". user deleted.");
    }

    private User findUserById(long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User couldn't find by id: " + id));
    }
}
