package fr.limoges.valadon.immersions.webapp.model;

import lombok.Data;


@Data

public class Etablissement {

    private Integer idEtablissement;
    private String nomEtablissement;
    private String villeEtablissement;
    private String departementEtablissement;
    private String emailContact;
    private String nomProviseur;
    private String prenomProviseur;
    private String civiliteProviseur;


}
