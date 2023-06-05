package com.factoriaf5.pruebatecnica.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.factoriaf5.pruebatecnica.models.User;

public interface UserRepository extends JpaRepository<User, Long>{
    public Optional<User> findByUsername(String username);
}