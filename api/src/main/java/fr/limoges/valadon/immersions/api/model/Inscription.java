package fr.limoges.valadon.immersions.api.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "inscription")
public class Inscription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_inscription")
    private int idInscription;

    @Column(name = "date_inscription", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dateInscription;

    @Column(name = "presence", nullable = false)
    private boolean presence;

    @Column(name = "statut", nullable = false)
    private boolean statut;

    @Column(name = "signature_parent", nullable = false)
    private boolean signatureParent;

    @ManyToOne(cascade = CascadeType.ALL) //CASCADE A CHANGER
    @JoinColumn(name = "id_session", nullable = false)
    private Session session;

    @OneToOne(cascade = CascadeType.ALL)//CASCADE A CHANGER
    @JoinColumn(name = "id_demande", nullable = false, unique = true)
    private Demande demande;

    public Inscription() {
    }

    public Inscription(Date dateInscription, boolean presence, boolean statut, boolean signatureParent, Session session, Demande demande) {
        this.dateInscription = dateInscription;
        this.presence = presence;
        this.statut = statut;
        this.signatureParent = signatureParent;
        this.session = session;
        this.demande = demande;
    }

    public int getIdInscription() {
        return idInscription;
    }

    public void setIdInscription(int idInscription) {
        this.idInscription = idInscription;
    }

    public Date getDateInscription() {
        return dateInscription;
    }

    public void setDateInscription(Date dateInscription) {
        this.dateInscription = dateInscription;
    }

    public boolean isPresence() {
        return presence;
    }

    public void setPresence(boolean presence) {
        this.presence = presence;
    }

    public boolean isStatut() {
        return statut;
    }

    public void setStatut(boolean statut) {
        this.statut = statut;
    }

    public boolean isSignatureParent() {
        return signatureParent;
    }

    public void setSignatureParent(boolean signatureParent) {
        this.signatureParent = signatureParent;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public Demande getDemande() {
        return demande;
    }

    public void setDemande(Demande demande) {
        this.demande = demande;
    }
}