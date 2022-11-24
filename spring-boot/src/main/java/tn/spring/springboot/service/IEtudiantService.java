package tn.spring.springboot.service;
import tn.spring.springboot.entity.Contrat;
import tn.spring.springboot.entity.Etudiant;
import tn.spring.springboot.entity.Option;

import java.util.List;

public interface IEtudiantService {
  /*  List<Etudiant> retrieveAllEtudiants();

    Etudiant addEtudiant (Etudiant e);

    Etudiant updateEtudiant (Etudiant e);

    Etudiant retrieveEtudiant(Integer idEtudiant);

    void removeEtudiant(Integer idEtudiant);*/
  List<Etudiant> getAllEtudiant();
    Etudiant addEtudiant(Etudiant E);
    Etudiant updateEtudiant(Etudiant E);
    void deleteEtudiant(int id);
    Etudiant getEtudiantbyid(int id);

    Etudiant findEtudiantByprenom(String prenom);

    void updateEtudiantByOption(Option op , int idEtudiant);

    List<Etudiant> retrieveEtudiantByEquipeThematique (  String thematique);
    public  void AssignEtudtoDepartement(int idEtudiant, int idDepart);

  public Etudiant addAndAssignEtudiantToEquipeAndContract(Etudiant e, Integer idContrat,Integer idEquipe);
  Contrat affectContratToEtudiant (Contrat ce, String nomE, String prenomE);

  List<Etudiant> getEtudiantsByDepartement(Integer idDepart);

}
