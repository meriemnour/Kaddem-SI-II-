package tn.spring.springboot.service;
import tn.spring.springboot.entity.Equipe;
import tn.spring.springboot.entity.Niveau;

import java.util.List;

public interface IEquipeService {

    /*List<Equipe> retrieveAllEquipes();

    Equipe addEquipe(Equipe e);

    Equipe updateEquipe (Equipe e);

    Equipe retrieveEquipe (Integer idEquipe);*/
    List<Equipe> getAlleqp();
    Equipe addeqp(Equipe E);
    Equipe updateeqp(Equipe E);
    void deleteeqp(int id);
    Equipe geteqbyid(int id);


    List<Equipe> findEquipesByEtudiantsIdEtudiant(int idEtudiant);
    List<Equipe>findEquipeByDetailEquipe1ThematiqueLike(String th);
    List<Equipe> findEquipesByEtudiantsIdEtudiantAndDetailEquipe1ThematiqueNotNull(int id);
    List<Equipe> findEquipesByEtudiantsIdEtudiantAndEtudiantsDepartementIdDepart(int id1,int id2);
    void deleteEquipeByNiveau( Niveau niveau);

    List<Equipe> retriveEquipeByNiveauAndThematique(Niveau niveau ,String thematique);


}
