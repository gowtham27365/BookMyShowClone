package com.example.bookmyshow.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bookmyshow.Models.User;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findById(Long Id);
}
