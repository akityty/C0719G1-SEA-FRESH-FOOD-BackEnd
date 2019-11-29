package com.codegym.freshfood.service.impl;

import com.codegym.freshfood.model.Provider;
import com.codegym.freshfood.repository.ProviderRepository;
import com.codegym.freshfood.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;

public class ProviderServiceImpl implements ProviderService {
    @Autowired
    private ProviderRepository providerRepository;
    @Override
    public Iterable<Provider> findAllProvider() {
        return providerRepository.findAll();
    }
}
