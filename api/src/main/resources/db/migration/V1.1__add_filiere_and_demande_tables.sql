CREATE TABLE filiere (
                         id_filiere INT AUTO_INCREMENT PRIMARY KEY,
                         nom_filiere VARCHAR(50),
                         id_domaine INT NOT NULL,
                         FOREIGN KEY (id_domaine) REFERENCES domaine_classe(id_domaine)
);

CREATE TABLE demande (
                         id_demande INT AUTO_INCREMENT PRIMARY KEY,
                         date_demande DATE,
                         id_filiere INT NOT NULL,
                         id_eleve INT NOT NULL,
                         FOREIGN KEY (id_filiere) REFERENCES filiere(id_filiere),
                         FOREIGN KEY (id_eleve) REFERENCES eleve(id_eleve)
);