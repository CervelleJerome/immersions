package fr.limoges.valadon.immersions.api.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Filiere {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idFiliere;

    private String nomFiliere;

    @ManyToOne(cascade = CascadeType.ALL)//CASCADE A CHANGER
    @JoinColumn(name = "id_domaine", nullable = false)
    private Domaine domaine;

    @OneToMany(mappedBy = "filiere", cascade = CascadeType.ALL)
    private List<Demande> demandes;

    // Getters et Setters
    public Integer getIdFiliere() {
        return idFiliere;
    }

    public void setIdFiliere(Integer idFiliere) {
        this.idFiliere = idFiliere;
    }

    public String getNomFiliere() {
        return nomFiliere;
    }

    public void setNomFiliere(String nomFiliere) {
        this.nomFiliere = nomFiliere;
    }

    public Domaine getDomaine() {
        return domaine;
    }

    public void setDomaine(Domaine domaine) {
        this.domaine = domaine;
    }

    public List<Demande> getDemandes() {
        return demandes;
    }

    public void setDemandes(List<Demande> demandes) {
        this.demandes = demandes;
    }
}
