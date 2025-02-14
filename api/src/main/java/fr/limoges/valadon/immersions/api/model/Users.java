package fr.limoges.valadon.immersions.api.model;

import jakarta.persistence.*;
import java.util.List;


@Entity
@Table(name = "users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUser;

    @Column(name = "nom_user")
    private String nomUser;

    @Column(name = "email_user")
    private String emailUser;

    @Column(name = "password")
    private String password;

    @Column(name = "role")
    private String role;

    @ManyToOne(cascade = CascadeType.ALL) //TYPE DE CASCADE A CHANGER SI BESOIN
    @JoinColumn(name = "id_etablissement")
    private Etablissement etablissement;

    // Getters and Setters
    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public String getNomUser() {
        return nomUser;
    }

    public void setNomUser(String nomUser) {
        this.nomUser = nomUser;
    }

    public String getEmailUser() {
        return emailUser;
    }

    public void setEmailUser(String emailUser) {
        this.emailUser = emailUser;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Etablissement getEtablissement() {
        return etablissement;
    }

    public void setEtablissement(Etablissement etablissement) {
        this.etablissement = etablissement;
    }
}
    