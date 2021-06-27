package com.example.springrestsample.repository;

import com.example.springrestsample.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findAllByName (String name);
    User findByUsername (String username);
}
