package com.rochards.citiesapi.repository;

import com.rochards.citiesapi.model.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City, Long> {
}
