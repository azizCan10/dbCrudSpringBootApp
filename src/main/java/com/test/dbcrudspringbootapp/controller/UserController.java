package com.test.dbcrudspringbootapp.controller;

import com.test.dbcrudspringbootapp.core.result.DataResult;
import com.test.dbcrudspringbootapp.core.result.Result;
import com.test.dbcrudspringbootapp.entity.User;
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

    @PostMapping("/add")
    public Result add(@RequestBody User user) {
        return userService.add(user);
    }

    @GetMapping("/getall")
    public DataResult<List<User>> getAll() {
        return userService.getAll();
    }

    @GetMapping("/getbyid/{id}")
    public DataResult<User> getById(@PathVariable long id) {
        return userService.getById(id);
    }

    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable long id) {
        return userService.delete(id);
    }
}
