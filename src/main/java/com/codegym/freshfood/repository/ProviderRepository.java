package com.codegym.freshfood.repository;

import com.codegym.freshfood.model.Provider;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProviderRepository extends JpaRepository<Provider, Long> {
}
