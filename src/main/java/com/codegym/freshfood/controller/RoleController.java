package com.codegym.freshfood.controller;

import com.codegym.freshfood.model.signinSignup.Role;
import com.codegym.freshfood.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired
    RoleService roleService;
    @PostMapping("/save")
    public ResponseEntity create(@RequestBody Role role){
            roleService.save(role);
            return new ResponseEntity(HttpStatus.CREATED);
    }
    @GetMapping("/list")
    public ResponseEntity<List<Role>> getAllRole(){
        List<Role> roleList = roleService.findAll();
        if(roleList != null){
            return new ResponseEntity<List<Role>>(roleList,HttpStatus.OK);
        }else{
            return new ResponseEntity<List<Role>>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/delete")
    public ResponseEntity deleteRole(@RequestBody Role role){
        roleService.delete(role);
        return new ResponseEntity(HttpStatus.OK);
    }
}
