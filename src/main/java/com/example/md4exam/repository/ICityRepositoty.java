package com.example.md4exam.repository;

import com.example.md4exam.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICityRepositoty extends JpaRepository<City,Long> {
}
