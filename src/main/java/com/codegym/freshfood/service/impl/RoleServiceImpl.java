package com.codegym.freshfood.service.impl;

import com.codegym.freshfood.model.signinSignup.Role;
import com.codegym.freshfood.model.signinSignup.RoleName;
import com.codegym.freshfood.repository.RoleRepository;
import com.codegym.freshfood.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class RoleServiceImpl implements RoleService {
   @Autowired
    RoleRepository roleRepository;
    @Override
    public Optional<Role> findByName(RoleName roleName) {
        return roleRepository.findByName(roleName);
    }

    @Override
    public void save(Role role) {
        roleRepository.save(role);
    }

    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }
}
