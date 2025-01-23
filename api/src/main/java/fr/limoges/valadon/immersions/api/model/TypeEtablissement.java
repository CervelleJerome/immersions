package fr.limoges.valadon.immersions.api.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "type_etablissement")
public class TypeEtablissement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idType;

    @Column(name = "nom_type")
    private String nomType;

    // Getters and Setters
    public Integer getIdType() {
        return idType;
    }

    public void setIdType(Integer idType) {
        this.idType = idType;
    }

    public String getNomType() {
        return nomType;
    }

    public void setNomType(String nomType) {
        this.nomType = nomType;
    }
}