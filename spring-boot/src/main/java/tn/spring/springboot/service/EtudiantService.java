package tn.spring.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.spring.springboot.entity.*;
import tn.spring.springboot.repository.IContractRepository;
import tn.spring.springboot.repository.IDepartementRepository;
import tn.spring.springboot.repository.IEquipeRepository;
import tn.spring.springboot.repository.IEtudiantRepository;

import javax.transaction.Transactional;
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

    @Autowired
    IEquipeRepository equipeRepository;

    @Autowired
    IContractRepository contractRepository;
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
    @Override
    public List<Etudiant> getEtudiantsByDepartement(Integer idDepart) {return etudiantRepository.findEtudiantByDepartement(idDepart);}

    @Transactional
    public Etudiant addAndAssignEtudiantToEquipeAndContract(Etudiant e, Integer idContrat, Integer idEquipe) {
        Contrat contrat = contractRepository.findById(idContrat).get();
        Equipe equipe = equipeRepository.findById(idEquipe).get();
        e.getContrats().add(contrat);
        e.getEquipes().add(equipe);
        // contrat.setEtudiant(e);
        etudiantRepository.save(e);
        //etudiantRepository.save(contrat);
        System.out.println(e.getContrats());

        return e ;

    }
    @Override
    public Contrat affectContratToEtudiant(Contrat ce, String nomE, String prenomE) {
        Etudiant e=etudiantRepository.findEtudiantByNomPrenom(nomE,prenomE);

        e.getContrats().add(ce);
        ce.setEtudiant(e);
        contractRepository.save(ce);
        etudiantRepository.save(e);
        return ce;
    }

}
