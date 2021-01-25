package com.rochards.citiesapi.controller;

import com.rochards.citiesapi.model.Country;
import com.rochards.citiesapi.repository.CountryRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/countries")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class CountryController {

    private final CountryRepository countryRepository;

    @GetMapping
    public ResponseEntity<Page<Country>> getAllCountries(Pageable page) {
        return ResponseEntity.ok(countryRepository.findAll(page));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Country> getCountryById(@PathVariable Long id) {
        Optional<Country> optCountry = countryRepository.findById(id);
        return optCountry.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
