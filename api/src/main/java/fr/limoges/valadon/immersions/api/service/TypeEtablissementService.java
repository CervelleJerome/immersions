package fr.limoges.valadon.immersions.api.service;

import fr.limoges.valadon.immersions.api.model.TypeEtablissement;
import fr.limoges.valadon.immersions.api.repository.TypeEtablissementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class TypeEtablissementService {

    @Autowired
    private TypeEtablissementRepository typeEtablissementRepository;

    // Récupérer tous les types d'établissements
    public List<TypeEtablissement> getAllTypesEtablissements() {
        return typeEtablissementRepository.findAll();
    }

    // Récupérer un type d'établissement par son ID
    public Optional<TypeEtablissement> getTypeEtablissementById(Integer id) {
        return typeEtablissementRepository.findById(id);
    }

    // Ajouter un nouveau type d'établissement
    public TypeEtablissement createTypeEtablissement(TypeEtablissement typeEtablissement) {
        return typeEtablissementRepository.save(typeEtablissement);
    }

    // Mettre à jour un type d'établissement
    public TypeEtablissement updateTypeEtablissement(Integer id, TypeEtablissement newTypeEtablissement) {
        return typeEtablissementRepository.findById(id).map(type -> {
            type.setNomType(newTypeEtablissement.getNomType());
            return typeEtablissementRepository.save(type);
        }).orElse(null);
    }

    // Supprimer un type d'établissement
    public void deleteTypeEtablissement(Integer id) {
        typeEtablissementRepository.deleteById(id);
    }
}
