package com.test.dbcrudspringbootapp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserRequest {
    @NotBlank(message = "Name must not be null.")
    private String name;

    @Min(value = 0, message = "Age must be greater than 0.")
    @NotNull(message = "Age must not be null.")
    private int age;
}
