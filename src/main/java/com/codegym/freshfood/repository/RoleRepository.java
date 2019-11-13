package com.codegym.freshfood.repository;

import com.codegym.freshfood.model.Role;
import com.codegym.freshfood.model.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
  Optional<Role> findByName(RoleName roleName);
}
