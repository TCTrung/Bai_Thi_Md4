package com.example.md4exam.service;

import com.example.md4exam.model.City;
import com.example.md4exam.repository.ICityRepositoty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CityService implements ICityService {
    @Autowired
    private ICityRepositoty cityRepositoty;
    @Override
    public List<City> findAll() {
        return cityRepositoty.findAll();
    }

    @Override
    public Optional<City> findById(Long id) {
        return cityRepositoty.findById(id);
    }

    @Override
    public void save(City city) {
        cityRepositoty.save(city);
    }

    @Override
    public void remove(Long id) {
        cityRepositoty.deleteById(id);
    }
}
