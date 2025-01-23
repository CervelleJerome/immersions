package fr.limoges.valadon.immersions.api.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "etablissement")
public class Etablissement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEtablissement;

    @Column(name = "nom_etablissement")
    private String nomEtablissement;

    @Column(name = "ville_etablissement")
    private String villeEtablissement;

    @Column(name = "departement_etablissement")
    private String departementEtablissement;

    @Column(name = "email_contact")
    private String emailContact;

    @Column(name = "nom_proviseur")
    private String nomProviseur;

    @Column(name = "prenom_proviseur")
    private String prenomProviseur;

    @Column(name = "civilite_proviseur")
    private String civiliteProviseur;

    @ManyToOne
    @JoinColumn(name = "id_type")
    private TypeEtablissement typeEtablissement;

    // Getters and Setters
    public Integer getIdEtablissement() {
        return idEtablissement;
    }

    public void setIdEtablissement(Integer idEtablissement) {
        this.idEtablissement = idEtablissement;
    }

    public String getNomEtablissement() {
        return nomEtablissement;
    }

    public void setNomEtablissement(String nomEtablissement) {
        this.nomEtablissement = nomEtablissement;
    }

    public String getVilleEtablissement() {
        return villeEtablissement;
    }

    public void setVilleEtablissement(String villeEtablissement) {
        this.villeEtablissement = villeEtablissement;
    }

    public String getDepartementEtablissement() {
        return departementEtablissement;
    }

    public void setDepartementEtablissement(String departementEtablissement) {
        this.departementEtablissement = departementEtablissement;
    }

    public String getEmailContact() {
        return emailContact;
    }

    public void setEmailContact(String emailContact) {
        this.emailContact = emailContact;
    }

    public String getNomProviseur() {
        return nomProviseur;
    }

    public void setNomProviseur(String nomProviseur) {
        this.nomProviseur = nomProviseur;
    }

    public String getPrenomProviseur() {
        return prenomProviseur;
    }

    public void setPrenomProviseur(String prenomProviseur) {
        this.prenomProviseur = prenomProviseur;
    }

    public String getCiviliteProviseur() {
        return civiliteProviseur;
    }

    public void setCiviliteProviseur(String civiliteProviseur) {
        this.civiliteProviseur = civiliteProviseur;
    }

    public TypeEtablissement getTypeEtablissement() {
        return typeEtablissement;
    }

    public void setTypeEtablissement(TypeEtablissement typeEtablissement) {
        this.typeEtablissement = typeEtablissement;
    }
}