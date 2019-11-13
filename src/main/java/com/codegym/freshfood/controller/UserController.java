package com.codegym.freshfood.controller;

import com.codegym.freshfood.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@ResponseBody
public class UserController {
   /* @Autowired
    private UserService userService;

    @RequestMapping(value = "/api", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<User>> listAllUsers() {
        List<User> users = userService.findAll();
        if (users.isEmpty()) {
            return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<User>>(users, HttpStatus.OK);
    }

    @RequestMapping(value = "/api" , method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> addMember(@RequestBody User user) {
        userService.save(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/api/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Optional<User>> getUser(@PathVariable Long id){
        Optional<User> user = userService.findById(id);
        if(user == null){
            return new ResponseEntity<Optional<User>>(HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<Optional<User>>(user,HttpStatus.OK);
        }
    }

    @RequestMapping(value = "api/checkLogin", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Long> checkLogin(@RequestParam String email,@RequestParam String password) {
        Long id = userService.checkLogin(email, password);
        if (id == -1L) return new ResponseEntity<Long>(HttpStatus.NOT_FOUND);
        else if (id == 0L) return new ResponseEntity<Long>(HttpStatus.BAD_REQUEST);
        else return new ResponseEntity<Long>(id, HttpStatus.OK);
    }*/
}
