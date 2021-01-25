package com.rochards.citiesapi.controller;

import com.rochards.citiesapi.service.DistanceService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("distances")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class DistanceController {

    private final DistanceService distanceService;

    @GetMapping("by-points")
    public ResponseEntity<Double> byPoints(@RequestParam(name = "from") Long cityId1,
        @RequestParam(name = "to") Long cityId2) {
        return ResponseEntity.ok(distanceService.distanceByPointsInMiles(cityId1, cityId2));
    }

    @GetMapping("by-cube")
    public ResponseEntity<Double> byCube(@RequestParam(name = "from") Long cityId1,
        @RequestParam(name = "to") Long cityId2) {
        return ResponseEntity.ok(distanceService.distanceByCubeInMeters(cityId1, cityId2));
    }
}
