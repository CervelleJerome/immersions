CREATE TABLE type_etablissement (
    id_type INT AUTO_INCREMENT PRIMARY KEY,
    nom_type VARCHAR(50)
);

CREATE TABLE domaine_classe (
    id_domaine INT AUTO_INCREMENT PRIMARY KEY,
    nom_domaine VARCHAR(50)
);

CREATE TABLE etablissement (
    id_etablissement INT AUTO_INCREMENT PRIMARY KEY,
    nom_etablissement VARCHAR(50),
    ville_etablissement VARCHAR(50),
    departement_etablissement VARCHAR(50),
    email_contact VARCHAR(50),
    nom_proviseur VARCHAR(50),
    prenom_proviseur VARCHAR(50),
    civilite_proviseur VARCHAR(50),
    id_domaine INT NOT NULL,
    id_type INT NOT NULL,
    FOREIGN KEY (id_domaine) REFERENCES domaine_classe(id_domaine),
    FOREIGN KEY (id_type) REFERENCES type_etablissement(id_type)
);

CREATE TABLE users (
    id_user INT AUTO_INCREMENT PRIMARY KEY,
    nom_user VARCHAR(50),
    email_user VARCHAR(50),
    password VARCHAR(50),
    role VARCHAR(50),
    id_etablissement INT NOT NULL,
    FOREIGN KEY (id_etablissement) REFERENCES etablissement(id_etablissement)
);