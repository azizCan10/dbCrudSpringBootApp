package com.test.dbcrudspringbootapp.controller;

import com.test.dbcrudspringbootapp.core.result.DataResult;
import com.test.dbcrudspringbootapp.core.result.Result;
import com.test.dbcrudspringbootapp.dto.CreateUserRequest;
import com.test.dbcrudspringbootapp.dto.UserDto;
import com.test.dbcrudspringbootapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @PostMapping
    public Result add(@RequestBody CreateUserRequest createUserRequest) {
        return userService.add(createUserRequest);
    }

    @GetMapping
    public DataResult<List<UserDto>> getAll() {
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public DataResult<UserDto> getById(@PathVariable long id) {
        return userService.getById(id);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable long id) {
        return userService.delete(id);
    }
}
