package com.rochards.citiesapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "pais")
@Data @AllArgsConstructor @NoArgsConstructor
public class Country {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "nome_pt")
    private String ptName;

    @Column(name = "sigla")
    private String code;

    private int bacen;
}
