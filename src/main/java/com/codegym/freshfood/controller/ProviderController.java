package com.codegym.freshfood.controller;

import com.codegym.freshfood.model.Provider;
import com.codegym.freshfood.service.ProviderService;
import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/provider", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProviderController {
    @Autowired
    private ProviderService providerService;

    @GetMapping("/list")
    public ResponseEntity showListProvider() {
        try {
            Iterable<Provider> providers = providerService.findAllProvider();
            return new ResponseEntity<Iterable<Provider>>(providers, HttpStatus.OK);
        } catch (ExpiredJwtException e) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/add")
    public ResponseEntity createProvider(@RequestBody Provider provider){
        providerService.save(provider);
        return new ResponseEntity(HttpStatus.OK);
    }
    @GetMapping("{id}")
    public ResponseEntity<Provider> getProvider(@PathVariable Long id){
        Optional<Provider> provider = providerService.findById(id);
        return new ResponseEntity<Provider>(provider.get(), HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteProvider(@PathVariable Long id){
       Optional<Provider> provider =  providerService.findById(id);
       providerService.delete(provider.get());
       return new ResponseEntity(HttpStatus.OK);
    }

}
