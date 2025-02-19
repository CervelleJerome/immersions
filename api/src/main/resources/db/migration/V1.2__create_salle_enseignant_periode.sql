CREATE TABLE salle (
    id_salle INT AUTO_INCREMENT PRIMARY KEY,
    numero_salle VARCHAR(50) NOT NULL
);

CREATE TABLE enseignant (
    id_enseignant INT AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(50) NOT NULL,
    civilite VARCHAR(50) NOT NULL
);

CREATE TABLE periode (
    id_periode VARCHAR(50) PRIMARY KEY,
    date_debut DATE NOT NULL,
    date_fin DATE NOT NULL
);
