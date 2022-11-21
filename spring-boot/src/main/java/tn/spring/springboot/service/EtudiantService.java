package tn.spring.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.spring.springboot.entity.Departement;
import tn.spring.springboot.entity.Etudiant;
import tn.spring.springboot.entity.Option;
import tn.spring.springboot.repository.IDepartementRepository;
import tn.spring.springboot.repository.IEquipeRepository;
import tn.spring.springboot.repository.IEtudiantRepository;
import java.util.List;

@Service
public class EtudiantService implements IEtudiantService{
   /* @Autowired
    private IEtudiantRepository ietudiantRepository;

    @Override
    public List<Etudiant> retrieveAllEtudiants() {
        return ietudiantRepository.findAll();
    }

    @Override
    public Etudiant addEtudiant(Etudiant e) {
        return ietudiantRepository.save(e);
    }

    @Override
    public Etudiant updateEtudiant(Etudiant e) {
        return ietudiantRepository.save(e);
    }

    @Override
    public Etudiant retrieveEtudiant(int idEtudiant) {
        return ietudiantRepository.findById(idEtudiant).get();
    }

    @Override
    public void removeEtudiant(int idEtudiant) {
        ietudiantRepository.deleteById(idEtudiant);
    }*/
    @Autowired
   IEtudiantRepository etudiantRepository;
    @Autowired
    IDepartementRepository departementRepository;
    @Override
    public List<Etudiant> getAllEtudiant() {
        return etudiantRepository.findAll();
    }

    @Override
    public Etudiant addEtudiant(Etudiant E) {
        return etudiantRepository.save(E);
    }

    @Override
    public Etudiant updateEtudiant(Etudiant E) {
        return etudiantRepository.save(E);
    }

    @Override
    public void deleteEtudiant(int id) {
        etudiantRepository.deleteById(id);
    }

    @Override
    public Etudiant getEtudiantbyid(int id) {

        return etudiantRepository.findById(id).orElse(null);
    }

    @Override
    public Etudiant findEtudiantByprenom(String prenom) {
        return etudiantRepository.findEtudiantByprenom(prenom);
    }

    @Override
    public void updateEtudiantByOption(Option op, int idEtudiant) {
        etudiantRepository.updateEtudiantByOption(op,idEtudiant);
    }

    @Override
    public List<Etudiant> retrieveEtudiantByEquipeThematique(String thematique) {
        return etudiantRepository.retrieveEtudiantByEquipeThematique(thematique);
    }

    @Override
    public void AssignEtudtoDepartement(int idEtudiant, int idDepart) {
        Etudiant etd=etudiantRepository.findById(idEtudiant).orElse(null);
        Departement dep=departementRepository.findById(idDepart).orElse(null);
        etd.setDepartement(dep);
        etudiantRepository.save(etd);
    }


}
