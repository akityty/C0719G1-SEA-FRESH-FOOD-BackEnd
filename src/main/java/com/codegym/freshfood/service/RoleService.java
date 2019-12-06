package com.codegym.freshfood.service;

import com.codegym.freshfood.model.signinSignup.Role;
import com.codegym.freshfood.model.signinSignup.RoleName;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface RoleService {
    Optional<Role> findByName(RoleName roleName);
    void save(Role role);
    List<Role> findAll();
    void delete(Role role);
}
