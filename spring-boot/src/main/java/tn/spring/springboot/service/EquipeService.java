package tn.spring.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.spring.springboot.entity.Equipe;
import tn.spring.springboot.entity.Etudiant;
import tn.spring.springboot.entity.Niveau;
import tn.spring.springboot.repository.IEquipeRepository;
import java.util.List;
@Service
public class EquipeService implements IEquipeService {
  /*  @Autowired
    private IEquipeRepository iEquipeRepository;


    @Override
    public List<Equipe> retrieveAllEquipes() {
        return (List<Equipe>) iEquipeRepository.findAll();

    }

    @Override
    public Equipe addEquipe(Equipe e) {
        return iEquipeRepository.save(e);
    }

    @Override
    public Equipe updateEquipe(Equipe e) {
        return iEquipeRepository.save(e);
    }

    @Override
    public Equipe retrieveEquipe(Integer idEquipe) {
        return iEquipeRepository.findById(idEquipe).get();
    }
*/


    @Autowired
    IEquipeRepository equipeRepository;

    @Override
    public List<Equipe> getAlleqp() {
        return equipeRepository.findAll();
    }

    @Override
    public Equipe addeqp(Equipe E) {
        return equipeRepository.save(E);
    }

    @Override
    public Equipe updateeqp(Equipe E) {
        return equipeRepository.save(E);
    }

    @Override
    public void deleteeqp(int id) {
        equipeRepository.deleteById(id);
    }

    @Override
    public Equipe geteqbyid(int id) {
        return equipeRepository.findById(id).orElse(null);
    }

    @Override
    public List<Equipe> findEquipesByEtudiantsIdEtudiant(int idEtudiant) {
        return equipeRepository.findEquipesByEtudiantsIdEtudiant(idEtudiant);
    }

    @Override
    public List<Equipe>findEquipeByDetailEquipe1ThematiqueLike(String th) {
        return equipeRepository.findEquipeByDetailEquipe1ThematiqueLike(th);
    }

    @Override
    public List<Equipe> findEquipesByEtudiantsIdEtudiantAndDetailEquipe1ThematiqueNotNull(int id) {
        return equipeRepository.findEquipesByEtudiantsIdEtudiantAndDetailEquipe1ThematiqueNotNull(id);
    }

    @Override
    public List<Equipe> findEquipesByEtudiantsIdEtudiantAndEtudiantsDepartementIdDepart(int id1, int id2) {
        return equipeRepository.findEquipesByEtudiantsIdEtudiantAndEtudiantsDepartementIdDepart(id1, id2);
    }

    @Override
    public void deleteEquipeByNiveau(Niveau niveau) {
        equipeRepository.deleteEquipeByNiveau(niveau);
    }

    @Override
    public List<Equipe> retriveEquipeByNiveauAndThematique(Niveau niveau, String thematique) {
        return equipeRepository.retriveEquipeByNiveauAndThematique(niveau,thematique);
    }




  /*  @Override
    public List<Equipe>findEquipeByEtudiantsAndDetailEquipe1ThematiqueNonNull(Long idEtudiant) {
        return  equipeRepository.findEquipeByEtudiantsAndDetailEquipe1ThematiqueNonNull(idEtudiant);
    }
*/
}
