package com.codegym.freshfood.controller;

import com.codegym.freshfood.message.request.LoginForm;
import com.codegym.freshfood.message.request.SignUpForm;
import com.codegym.freshfood.message.response.JwtResponse;
import com.codegym.freshfood.model.Role;
import com.codegym.freshfood.model.RoleName;
import com.codegym.freshfood.model.User;
import com.codegym.freshfood.repository.RoleRepository;
import com.codegym.freshfood.repository.UserRepository;
import com.codegym.freshfood.security.jwt.JwtProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthRestAPIs {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtProvider jwtProvider;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginForm loginRequest) {
        System.out.println("ok");
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtProvider.generateJwtToken(authentication);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        return ResponseEntity.ok(new JwtResponse(jwt, userDetails.getUsername(), userDetails.getAuthorities()));
    }

    @PostMapping(value = "/signup", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity registerUser(@Valid @RequestBody SignUpForm signUpRequest) {
        if (userRepository.existsByUsername(signUpRequest.getUsername())) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

        // Creating user's account
        User user = new User(signUpRequest.getName(), signUpRequest.getUsername(),
                signUpRequest.getEmail(), encoder.encode(signUpRequest.getPassword()));

        Set<String> strRoles = signUpRequest.getRole();
        Set<Role> roles = new HashSet<>();
        Role userRole = roleRepository.findByName(RoleName.ROLE_USER)
                .orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
        roles.add(userRole);

        user.setRoles(roles);
        userRepository.save(user);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/view/user/{name}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<Optional<User>> userDetails(@PathVariable("name") String userName) {
        try {
            Optional<User> user = userRepository.findByUsername(userName);
            return new ResponseEntity<Optional<User>>(user, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update/user")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity updateUser(@RequestBody User user) {
      try {
        userRepository.save(user);
        return new ResponseEntity(HttpStatus.OK);
      }catch (Exception e){
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
      }

    }

    @PutMapping("/update/pass/user")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity updatePasswordUser(@RequestBody User user) {
      try {
        user.setPassword(encoder.encode(user.getPassword()));
        userRepository.save(user);
        return new ResponseEntity(HttpStatus.OK);
      }catch (Exception e){
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
      }
    }
}