package com.factoriaf5.pruebatecnica.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.factoriaf5.pruebatecnica.models.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{
    
}