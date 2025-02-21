package fr.limoges.valadon.immersions.api.model;


import jakarta.persistence.*;


import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "session")
public class Session {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_session")
    private int idSession;

    @Column(name = "date_session", nullable = false)
    private LocalDate dateSession;

    @Column(name = "heure_debut", nullable = false)
    private LocalTime heureDebut;

    @Column(name = "heure_fin", nullable = false)
    private LocalTime heureFin;

    @Column(name = "description")
    private String description;

    @ManyToOne(cascade = CascadeType.ALL)//A CHANGER
    @JoinColumn(name = "id_periode", nullable = false)
    private Periode periode;

    @ManyToOne(cascade = CascadeType.ALL)//A CHANGER
    @JoinColumn(name = "id_salle", nullable = false)
    private Salle salle;

    @ManyToOne(cascade = CascadeType.ALL)//A CHANGER
    @JoinColumn(name = "id_enseignant", nullable = false)
    private Enseignant enseignant;

    @ManyToOne(cascade = CascadeType.ALL)//A CHANGER
    @JoinColumn(name = "id_filiere", nullable = false)
    private Filiere filiere;

    // Constructeurs
    public Session() {
    }

    public Session(LocalDate dateSession, LocalTime heureDebut, LocalTime heureFin, String description,
                   Periode periode, Salle salle, Enseignant enseignant, Filiere filiere) {
        this.dateSession = dateSession;
        this.heureDebut = heureDebut;
        this.heureFin = heureFin;
        this.description = description;
        this.periode = periode;
        this.salle = salle;
        this.enseignant = enseignant;
        this.filiere = filiere;
    }

    // Getters et Setters
    public int getIdSession() {
        return idSession;
    }

    public void setIdSession(int idSession) {
        this.idSession = idSession;
    }

    public LocalDate getDateSession() {
        return dateSession;
    }

    public void setDateSession(LocalDate dateSession) {
        this.dateSession = dateSession;
    }

    public LocalTime getHeureDebut() {
        return heureDebut;
    }

    public void setHeureDebut(LocalTime heureDebut) {
        this.heureDebut = heureDebut;
    }

    public LocalTime getHeureFin() {
        return heureFin;
    }

    public void setHeureFin(LocalTime heureFin) {
        this.heureFin = heureFin;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Periode getPeriode() {
        return periode;
    }

    public void setPeriode(Periode periode) {
        this.periode = periode;
    }

    public Salle getSalle() {
        return salle;
    }

    public void setSalle(Salle salle) {
        this.salle = salle;
    }

    public Enseignant getEnseignant() {
        return enseignant;
    }

    public void setEnseignant(Enseignant enseignant) {
        this.enseignant = enseignant;
    }

    public Filiere getFiliere() {
        return filiere;
    }

    public void setFiliere(Filiere filiere) {
        this.filiere = filiere;
    }
}
