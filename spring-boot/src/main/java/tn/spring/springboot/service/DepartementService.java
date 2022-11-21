package tn.spring.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.spring.springboot.entity.Departement;
import tn.spring.springboot.entity.Etudiant;
import tn.spring.springboot.entity.Option;
import tn.spring.springboot.repository.IDepartementRepository;
import java.util.List;
@Service
public class DepartementService implements IDerpartementService {
  /*  @Autowired
    IDepartementRepository iDepartementRepository;

    @Override
    public Departement getDepartement(int departement) {
        return null;
    }

    @Override
    public List<Departement> retrieveAllDepartements() {
        return (List<Departement>) iDepartementRepository.findAll();
    }

    @Override
    public Departement addDepartement(Departement d) {
        return iDepartementRepository.save(d);
    }

    @Override
    public Departement updateDepartement(Departement d) {
        return iDepartementRepository.save(d);
    }

    @Override
    public Departement retrieveDepartement(Integer idDepart) {
        return iDepartementRepository.findById(idDepart).get();
    }

    getbyid

     */

    @Autowired
    IDepartementRepository departementRepository;


    @Override
    public List<Departement> getAlldep() {
        return departementRepository.findAll();
    }

    @Override
    public Departement addep(Departement D) {
        return departementRepository.save(D);
    }

    @Override
    public Departement updatedep(Departement D) {
        return departementRepository.save(D);
    }

    @Override
    public void deletedep(int id) {
        departementRepository.deleteById(id);

    }

    @Override
    public Departement getdepbyid(int id) {
        return departementRepository.findById(id).orElse(null);
    }

    @Override
    public List<Departement> retrieveDepartementByOptionEtudiant(Option op) {
        return departementRepository.retrieveDepartementByOptionEtudiant(op);
    }

}
