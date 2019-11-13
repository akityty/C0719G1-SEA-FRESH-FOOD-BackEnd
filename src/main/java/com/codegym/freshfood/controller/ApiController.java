package com.codegym.freshfood.controller;

import com.codegym.freshfood.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/*@CrossOrigin("*")
@RestController*/
public class ApiController {
 /* @Autowired
  private UserService userService;
  @Autowired
  private PasswordEncoder passwordEncoder;

  @ResponseBody
  @RequestMapping(value = "/api", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<User>> listMember() {
    System.out.println("ok");
    List<User> footballPlayers = userService.findAll();
    if (footballPlayers.isEmpty()) {
      return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);
    }
    return new ResponseEntity<List<User>>(footballPlayers, HttpStatus.OK);
  }

  @ResponseBody
  @RequestMapping(value = "/api/add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Void> addUser(@RequestBody User user) {
    System.out.println("ok");
    User user1 = new User();
    if (userService.findByEmail(user.getEmail()) == null) {
      user1.setEmail(user.getEmail());
      user1.setPassword(passwordEncoder.encode(user.getPassword()));
      *//*user1.setRole(user.getRole());*//*
      userService.save(user1);
      return new ResponseEntity<Void>(HttpStatus.OK);
    }
    return new ResponseEntity<Void>(HttpStatus.FAILED_DEPENDENCY);
  }

  @RequestMapping(value = "/api/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Optional<User>> getUser(@PathVariable Long id) {
    Optional<User> user = userService.findById(id);
    if (!user.isPresent()) {
      return new ResponseEntity<Optional<User>>(HttpStatus.NOT_FOUND);
    } else {
      return new ResponseEntity<Optional<User>>(user, HttpStatus.OK);
    }
  }
  @RequestMapping(value = "api/checkLogin", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Long> checkLogin(@RequestParam String email,@RequestParam String password) {
    Long id = userService.checkLogin(email, password);
    if (id == -1L) return new ResponseEntity<Long>(HttpStatus.NOT_FOUND);
    else if (id == 0L) return new ResponseEntity<Long>(HttpStatus.BAD_REQUEST);
    else return new ResponseEntity<Long>(id, HttpStatus.UNAUTHORIZED);
  }
*/
}
