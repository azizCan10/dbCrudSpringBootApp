package com.test.dbcrudspringbootapp.repository;

import com.test.dbcrudspringbootapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
