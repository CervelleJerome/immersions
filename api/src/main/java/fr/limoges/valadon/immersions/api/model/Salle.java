package fr.limoges.valadon.immersions.api.model;

import jakarta.persistence.*;

@Entity
public class Salle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idSalle;

    @Column(nullable = false, length = 50)
    private String numeroSalle;

    // Constructeurs
    public Salle() {}

    public Salle(String numeroSalle) {
        this.numeroSalle = numeroSalle;
    }

    // Getters et Setters
    public Integer getIdSalle() {
        return idSalle;
    }

    public void setIdSalle(Integer idSalle) {
        this.idSalle = idSalle;
    }

    public String getNumeroSalle() {
        return numeroSalle;
    }

    public void setNumeroSalle(String numeroSalle) {
        this.numeroSalle = numeroSalle;
    }
}