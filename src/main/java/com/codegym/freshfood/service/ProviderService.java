package com.codegym.freshfood.service;

import com.codegym.freshfood.model.Provider;

import java.util.Optional;

public interface ProviderService {
    Iterable<Provider> findAllProvider();
    void save(Provider provider);
    void delete(Provider provider);
    Optional<Provider> findById(Long id);
}
