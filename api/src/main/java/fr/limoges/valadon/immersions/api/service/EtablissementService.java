package fr.limoges.valadon.immersions.api.service;

import fr.limoges.valadon.immersions.api.model.Etablissement;
import fr.limoges.valadon.immersions.api.repository.EtablissementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EtablissementService {

    @Autowired
    private EtablissementRepository etablissementRepository;

    public List<Etablissement> getAllEtablissements() {
        return etablissementRepository.findAll();
    }

    public Optional<Etablissement> getEtablissementById(Integer id) {
        return etablissementRepository.findById(id);
    }

    public Etablissement createEtablissement(Etablissement etablissement) {
        return etablissementRepository.save(etablissement);
    }

    public Etablissement updateEtablissement(Integer id, Etablissement etablissementDetails) {
        return etablissementRepository.findById(id).map(etablissement -> {
            etablissement.setNomEtablissement(etablissementDetails.getNomEtablissement());
            etablissement.setVilleEtablissement(etablissementDetails.getVilleEtablissement());
            etablissement.setDepartementEtablissement(etablissementDetails.getDepartementEtablissement());
            etablissement.setEmailContact(etablissementDetails.getEmailContact());
            etablissement.setNomProviseur(etablissementDetails.getNomProviseur());
            etablissement.setPrenomProviseur(etablissementDetails.getPrenomProviseur());
            etablissement.setCiviliteProviseur(etablissementDetails.getCiviliteProviseur());
            etablissement.setTypeEtablissement(etablissementDetails.getTypeEtablissement());
            etablissement.setDomaine(etablissementDetails.getDomaine());
            return etablissementRepository.save(etablissement);
        }).orElse(null);
    }

    public void deleteEtablissement(Integer id) {
        etablissementRepository.deleteById(id);
    }
}
