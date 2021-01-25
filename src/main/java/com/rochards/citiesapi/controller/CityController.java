package com.rochards.citiesapi.controller;

import com.rochards.citiesapi.model.City;
import com.rochards.citiesapi.repository.CityRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("cities")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class CityController {

    private final CityRepository cityRepository;

    @GetMapping
    public ResponseEntity<Page<City>> getAllCities(Pageable page) {
        return ResponseEntity.ok(cityRepository.findAll(page));
    }
}
