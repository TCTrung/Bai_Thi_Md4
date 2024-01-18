package com.example.md4exam.service;

import com.example.md4exam.model.Country;

import java.util.List;
import java.util.Optional;

public interface ICountryService {
    List<Country> findAll();
    Optional<Country> findById(Long id);
    void save(Country country);
}
