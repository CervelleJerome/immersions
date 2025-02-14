package fr.limoges.valadon.immersions.api.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "eleve")
public class Eleve {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_eleve")
    private int idEleve;

    @Column(name = "nom_eleve", nullable = false, length = 50)
    private String nomEleve;

    @Column(name = "prenom_eleve", nullable = false, length = 50)
    private String prenomEleve;

    @Column(name = "date_naissance", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dateNaissance;

    @Column(name = "regime_scolaire", nullable = false, length = 50)
    private String regimeScolaire;

    @Column(name = "classe", nullable = false, length = 50)
    private String classe;

    @ManyToOne(cascade = CascadeType.ALL) // TYPE DE CASCADE A CHANGER
    @JoinColumn(name = "id_etablissement", nullable = false)
    private Etablissement etablissement;

    // Getters and Setters

    public int getIdEleve() {
        return idEleve;
    }

    public void setIdEleve(int idEleve) {
        this.idEleve = idEleve;
    }

    public String getNomEleve() {
        return nomEleve;
    }

    public void setNomEleve(String nomEleve) {
        this.nomEleve = nomEleve;
    }

    public String getPrenomEleve() {
        return prenomEleve;
    }

    public void setPrenomEleve(String prenomEleve) {
        this.prenomEleve = prenomEleve;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }
    public String getRegimeScolaire() {
        return regimeScolaire;
    }

    public void setRegimeScolaire(String regimeScolaire) {
        this.regimeScolaire = regimeScolaire;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public Etablissement getEtablissement() {
        return etablissement;
    }

    public void setEtablissement(Etablissement etablissement) {
        this.etablissement = etablissement;
    }

    public Eleve() {
    }
}
