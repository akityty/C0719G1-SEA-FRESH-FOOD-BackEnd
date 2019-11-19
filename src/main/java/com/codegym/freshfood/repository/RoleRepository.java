package com.codegym.freshfood.repository;

import com.codegym.freshfood.model.signinSignup.Role;
import com.codegym.freshfood.model.signinSignup.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleName roleName);
}