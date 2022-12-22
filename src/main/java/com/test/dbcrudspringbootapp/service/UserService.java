package com.test.dbcrudspringbootapp.service;

import com.test.dbcrudspringbootapp.core.result.DataResult;
import com.test.dbcrudspringbootapp.core.result.Result;
import com.test.dbcrudspringbootapp.core.result.SuccessDataResult;
import com.test.dbcrudspringbootapp.core.result.SuccessResult;
import com.test.dbcrudspringbootapp.entity.User;
import com.test.dbcrudspringbootapp.exception.UserNotFoundException;
import com.test.dbcrudspringbootapp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    public Result add(User user) {
        userRepository.save(user);
        return new SuccessResult("User added. Name: " + user.getName());
    }

    public DataResult<List<User>> getAll() {
        return new SuccessDataResult<>(userRepository.findAll(), "All users listed.");
    }

    public DataResult<User> getById(long id) {
        return new SuccessDataResult<>(userRepository.findById(id)
                .orElseThrow(
                        () -> new UserNotFoundException("User couldn't find by id: " + id)), "User listed.");
    }

    public Result delete(long id) {
        userRepository.deleteById(id);
        return new SuccessResult(id + ". user deleted.");
    }
}
