package com.test.dbcrudspringbootapp.repository;

import com.test.dbcrudspringbootapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
