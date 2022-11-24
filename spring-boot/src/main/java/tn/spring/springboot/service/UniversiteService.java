package tn.spring.springboot.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.spring.springboot.entity.Departement;
import tn.spring.springboot.entity.Etudiant;
import tn.spring.springboot.entity.Universite;
import tn.spring.springboot.repository.IDepartementRepository;
import tn.spring.springboot.repository.IUniversiteRepository;

import java.util.List;

@Service
public class UniversiteService implements IUniversiteService{
   /* @Autowired
    private IUniversiteRepository iUniversiteRepository;


   @Override
    public List<Universite> retrieveAllUniversites() {
        return (List<Universite>) iUniversiteRepository.findAll();
    }

    @Override
    public Universite addUniversite(Universite u) {
        return iUniversiteRepository.save(u);
    }

    @Override
    public Universite updateUniversite(Universite u) {
        return iUniversiteRepository.save(u);
    }

    @Override
    public Universite retrieveUniversite(Integer idUniversite) {
        return iUniversiteRepository.findById(idUniversite).get();*/

    IUniversiteRepository universiteRepository;

    IDepartementRepository iDepartementRepository;
    @Override
    public List<Universite> getAllUniv() {
        return universiteRepository.findAll();
    }

    @Override
    public Universite addUniv(Universite U) {
        return universiteRepository.save(U);
    }

    @Override
    public Universite updateUni(Universite U) {
        return universiteRepository.save(U);
    }

    @Override
    public void deleteUni(int id) {
        universiteRepository.deleteById(id);

    }

    @Override
    public Universite getUnid(int id) {
        return universiteRepository.findById(id).orElse(null);
    }

    @Override
    public void assignDepartToUni(int idU, int dep) {
        Universite universite =universiteRepository.findById(idU).orElse(null);
        Departement departement =iDepartementRepository.findById(dep).orElse(null);
        universite.getDepartement().add(departement);
        universiteRepository.save(universite);


    }

    @Override
    public List<Departement> retrieveDepartementsByUniversite(Integer idUniversite) {
        return universiteRepository.retrieveDepartementsByUniversite(idUniversite);
    }
}

