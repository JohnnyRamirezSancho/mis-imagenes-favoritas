package com.factoriaf5.pruebatecnica.services;

import org.springframework.stereotype.Service;

import com.factoriaf5.pruebatecnica.models.Role;
import com.factoriaf5.pruebatecnica.repositories.RoleRepository;

import java.util.List;

@Service
public class RoleService {
    private RoleRepository repository;

    public RoleService(RoleRepository repository) {
        this.repository = repository;
    }

    public List<Role> getAll() {
        return repository.findAll();
    }

    public Role getOne(Long id) {
        Role role = repository.findById(id).orElse(null);
        return role;
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public Role save(Role role) {
        Role newRole=repository.save(role);
        return newRole;
    }
}
