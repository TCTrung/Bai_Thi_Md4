package com.example.md4exam.service;

import com.example.md4exam.model.City;

import java.util.List;
import java.util.Optional;

public interface ICityService {
    List<City> findAll();
    Optional<City> findById(Long id);

    void save(City city);

    void remove(Long id);
}
