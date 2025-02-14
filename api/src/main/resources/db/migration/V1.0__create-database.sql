-- Script de création des tables

CREATE TABLE type_etablissement (
                                    id_type INT AUTO_INCREMENT PRIMARY KEY,
                                    nom_type VARCHAR(50)
);

INSERT INTO type_etablissement (nom_type) VALUES
                                              ('Collège'),
                                              ('Lycée'),
                                              ('Lycée Professionnel'),
                                              ('Cité Scolaire'),
                                              ('MFR'),
                                              ('MLDS'),
                                              ('CNED');

CREATE TABLE domaine_classe (
                                id_domaine INT AUTO_INCREMENT PRIMARY KEY,
                                nom_domaine VARCHAR(50)
);

INSERT INTO domaine_classe (nom_domaine) VALUES
                                             ('3ème Collège du Secteur Valadon'),
                                             ('3ème Collège Secteur'),
                                             ('2nde');

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

INSERT INTO etablissement (nom_etablissement, ville_etablissement, departement_etablissement, email_contact, nom_proviseur, prenom_proviseur, civilite_proviseur, id_domaine, id_type)
VALUES
    ('Lycée Suzanne Valadon', 'Limoges', 'Haute-Vienne', 'contact@valadon.fr', 'Dupont', 'Jean', 'M.', 1, 2);

CREATE TABLE eleve (
                       id_eleve INT AUTO_INCREMENT PRIMARY KEY,
                       nom_eleve VARCHAR(50),
                       prenom_eleve VARCHAR(50),
                       date_naissance DATE,
                       regime_scolaire VARCHAR(50),
                       classe VARCHAR(50),
                       id_etablissement INT NOT NULL,
                       FOREIGN KEY (id_etablissement) REFERENCES etablissement(id_etablissement)
);

CREATE TABLE users (
                       id_user INT AUTO_INCREMENT PRIMARY KEY,
                       nom_user VARCHAR(50),
                       email_user VARCHAR(50),
                       password VARCHAR(60),
                       role VARCHAR(50),
                       id_etablissement INT NOT NULL,
                       FOREIGN KEY (id_etablissement) REFERENCES etablissement(id_etablissement)
);

INSERT INTO users (nom_user, email_user, password, role, id_etablissement)
VALUES
    ('user', 'user@test.com', '$2y$10$.qkbukzzX21D.bqbI.B2R.tvWP90o/Y16QRWVLodw51BHft7ZWbc.', 'USER', 1),
    ('admin', 'admin@test.com', '$2y$10$kp1V7UYDEWn17WSK16UcmOnFd1mPFVF6UkLrOOCGtf24HOYt8p1iC', 'ADMIN', 1);
