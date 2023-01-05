package com.test.dbcrudspringbootapp.controller;

import com.test.dbcrudspringbootapp.dto.CreateUserRequest;
import com.test.dbcrudspringbootapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<?> add(@Valid @RequestBody CreateUserRequest createUserRequest) {
        return ResponseEntity.ok(userService.add(createUserRequest));
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(userService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable long id) {
        return ResponseEntity.ok(userService.getById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable long id) {
        return ResponseEntity.ok(userService.delete(id));
    }
}
