package com.rochards.citiesapi.model;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;
import java.util.List;

@Entity(name = "estado")
@Data @AllArgsConstructor @NoArgsConstructor
@TypeDefs({@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)}) // definindo jsonb como JsonBinaryType
public class State {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "nome")
    private String name;

    private String uf;
    private String ibge;

//    @Column(name = "pais")
//    private Integer countryId;

    @ManyToOne // um pais pode ter varios estados
    // o nome da coluna na tabela eh pais. Esse campo corresponde a coluna de id tabela pais
    @JoinColumn(name = "pais", referencedColumnName = "id")
    private Country country;

    @Type(type = "jsonb") // pq no bd o tipo de ddd eh um json
    @Basic(fetch = FetchType.LAZY)
    //@Column(name = "ddd", columnDefinition = "jsonb")
    private List<Integer> ddd;
}
