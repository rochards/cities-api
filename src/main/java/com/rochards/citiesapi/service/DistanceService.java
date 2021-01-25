package com.rochards.citiesapi.service;

import com.rochards.citiesapi.model.City;
import com.rochards.citiesapi.repository.CityRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Point;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class DistanceService {

    private final CityRepository cityRepository;

    public Double distanceByPointsInMiles(Long cityId1, Long cityId2) {
        return cityRepository.distanceByPoints(cityId1, cityId2);
    }

    public Double distanceByCubeInMeters(Long cityId1, Long cityId2) {
        List<City> cities = cityRepository.findAllById(Arrays.asList(cityId1, cityId2));

        Point geolocation1 = new Point(cities.get(0).getLatitude(), cities.get(0).getLongitude());
        Point geolocation2 = new Point(cities.get(1).getLatitude(), cities.get(1).getLongitude());

        return cityRepository.distanceByCube(geolocation1.getX(), geolocation1.getY(), geolocation2.getX(),
                geolocation2.getY());
    }
}
