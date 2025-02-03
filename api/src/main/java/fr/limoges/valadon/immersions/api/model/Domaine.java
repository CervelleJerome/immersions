package fr.limoges.valadon.immersions.api.model;

import jakarta.persistence.*;

@Entity
@Table(name = "domaine")
public class Domaine{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDomaine;

    @Column(name = "nom_domaine", nullable = false, length = 50)
    private String nomDomaine;

    // Getters and Setters
    public Integer getIdDomaine() {
        return idDomaine;
    }

    public void setIdDomaine(Integer idDomaine) {
        this.idDomaine = idDomaine;
    }

    public String getNomDomaine() {
        return nomDomaine;
    }

    public void setNomDomaine(String nomDomaine) {
        this.nomDomaine = nomDomaine;
    }
}
