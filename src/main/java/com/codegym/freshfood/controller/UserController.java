package com.codegym.freshfood.controller;

import com.codegym.freshfood.model.signinSignup.Role;
import com.codegym.freshfood.model.signinSignup.RoleName;
import com.codegym.freshfood.model.signinSignup.User;
import com.codegym.freshfood.security.services.UserDetailsServiceImpl;
import com.codegym.freshfood.service.RoleService;
import com.codegym.freshfood.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    RoleService roleService;
    @Autowired
    UserService userService;
    @Autowired
    UserDetailsServiceImpl userDetailsService;
    @GetMapping("/list")
    public ResponseEntity<List<User>> getAllUser(){
        List<User> userList = userService.findAll();
        return new ResponseEntity<List<User>>(userList, HttpStatus.OK);
    }
    @PostMapping("/save")
    public ResponseEntity createUser(User user){
        userService.save(user);
        return new ResponseEntity(HttpStatus.CREATED);
    }
    @PutMapping("/updateRoleAdmin")
    public ResponseEntity updateUserRoleToAdmin() {
        User currentUser = userDetailsService.getCurrentUser();
        Set<Role> roleSet = currentUser.getRoles();
        Optional<Role> roleAdmin = roleService.findByName(RoleName.ROLE_ADMIN);
        roleSet.add(roleAdmin.get());
        currentUser.setRoles(roleSet);
        userService.save(currentUser);
        return new ResponseEntity(HttpStatus.OK);
    }
    @DeleteMapping("/delete")
    public ResponseEntity deleteUser(@RequestBody User user){
        userService.delete(user);
        return new ResponseEntity(HttpStatus.OK);
    }
}
