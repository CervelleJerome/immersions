CREATE TABLE session (
                         id_session INT AUTO_INCREMENT PRIMARY KEY,
                         date_session DATE NOT NULL,
                         heure_debut TIME NOT NULL,
                         heure_fin TIME NOT NULL,
                         description VARCHAR(50),
                         id_periode VARCHAR(50) NOT NULL,
                         id_salle INT NOT NULL,
                         id_enseignant INT NOT NULL,
                         id_filiere INT NOT NULL,
                         FOREIGN KEY (id_periode) REFERENCES periode(id_periode),
                         FOREIGN KEY (id_salle) REFERENCES salle(id_salle),
                         FOREIGN KEY (id_enseignant) REFERENCES enseignant(id_enseignant),
                         FOREIGN KEY (id_filiere) REFERENCES filiere(id_filiere)
);

CREATE TABLE inscription (
                             id_inscription INT AUTO_INCREMENT PRIMARY KEY,
                             date_inscription DATE NOT NULL,
                             presence BOOLEAN NOT NULL,
                             statut BOOLEAN NOT NULL,
                             signature_parent BOOLEAN NOT NULL,
                             id_session INT,
                             id_demande INT NOT NULL UNIQUE,
                             FOREIGN KEY (id_session) REFERENCES session(id_session),
                             FOREIGN KEY (id_demande) REFERENCES demande(id_demande)
);
