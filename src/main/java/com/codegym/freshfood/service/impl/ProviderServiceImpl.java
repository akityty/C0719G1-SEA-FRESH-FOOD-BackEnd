package com.codegym.freshfood.service.impl;

import com.codegym.freshfood.model.Provider;
import com.codegym.freshfood.repository.ProviderRepository;
import com.codegym.freshfood.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class ProviderServiceImpl implements ProviderService {
    @Autowired
    private ProviderRepository providerRepository;
    @Override
    public Iterable<Provider> findAllProvider() {
        return providerRepository.findAll();
    }

    @Override
    public void save(Provider provider) {
        providerRepository.save(provider);
    }

    @Override
    public void delete(Provider provider) {
        providerRepository.delete(provider);
    }

    @Override
    public Optional<Provider> findById(Long id) {
        return providerRepository.findById(id);
    }
}
