package fr.limoges.valadon.immersions.api.model;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Demande {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDemande;

    private LocalDate dateDemande;

    @ManyToOne(cascade = CascadeType.ALL)//CASCADE A CHANGER
    @JoinColumn(name = "id_filiere", nullable = false)
    private Filiere filiere;

    @OneToOne(cascade = CascadeType.ALL)//CASCADE A CHANGER
    @JoinColumn(name = "id_eleve", nullable = false, unique = true)
    private Eleve eleve;

    // Getters et Setters
    public Integer getIdDemande() {
        return idDemande;
    }

    public void setIdDemande(Integer idDemande) {
        this.idDemande = idDemande;
    }

    public LocalDate getDateDemande() {
        return dateDemande;
    }

    public void setDateDemande(LocalDate dateDemande) {
        this.dateDemande = dateDemande;
    }

    public Filiere getFiliere() {
        return filiere;
    }

    public void setFiliere(Filiere filiere) {
        this.filiere = filiere;
    }

    public Eleve getEleve() {
        return eleve;
    }

    public void setEleve(Eleve eleve) {
        this.eleve = eleve;
    }
}
