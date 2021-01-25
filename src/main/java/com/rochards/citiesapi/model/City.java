package com.rochards.citiesapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.springframework.data.geo.Point;

import javax.persistence.*;

@Entity(name = "cidade")
@Data @AllArgsConstructor @NoArgsConstructor
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "nome")
    private String name;

    private Integer uf;
    private Integer ibge;

    @Column(name = "lat_lon")
    private String geolocation;

    private Double latitude;
    private Double longitude;

}
