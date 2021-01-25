package com.rochards.citiesapi.repository;

import com.rochards.citiesapi.model.State;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StateRepository extends JpaRepository<State, Long> {
}
