package com.rochards.citiesapi.repository;

import com.rochards.citiesapi.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {

    @Query(value = "SELECT ((SELECT lat_lon FROM cidade WHERE id=?1) <@>(SELECT lat_lon FROM cidade WHERE id=?2))", nativeQuery = true)
    Double distanceByPoints(Long cityId1, Long cityId2);

    @Query(value = "select earth_distance(ll_to_earth(?1,?2), ll_to_earth(?3,?4)) as distance", nativeQuery = true)
    Double distanceByCube(double lat1, double lon1, double lat2, double lon2);
}
