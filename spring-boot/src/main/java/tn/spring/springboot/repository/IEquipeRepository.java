package tn.spring.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import tn.spring.springboot.entity.Equipe;
import tn.spring.springboot.entity.Niveau;

import java.util.List;

@Repository
@Component
public interface IEquipeRepository extends JpaRepository<Equipe, Integer>  {
    List<Equipe> findEquipesByEtudiantsIdEtudiant(int idEtudiant);
    List<Equipe>findEquipeByDetailEquipe1ThematiqueLike(String th);

    List<Equipe> findEquipesByEtudiantsIdEtudiantAndDetailEquipe1ThematiqueNotNull(int id);
    List<Equipe> findEquipesByEtudiantsIdEtudiantAndEtudiantsDepartementIdDepart(int id1,int id2);

    @Modifying
    @Transactional
    @Query(" DELETE  FROM Equipe e WHERE e.niveau = :niveau")
    void deleteEquipeByNiveau( @Param("niveau") Niveau niveau);



    @Query("SELECT  equipe from Equipe equipe , DetailEquipe deq where equipe.idEquipe = deq.equipe.idEquipe and deq.thematique= :thematique and equipe.niveau= :niveau")
    List<Equipe> retriveEquipeByNiveauAndThematique(@Param("niveau") Niveau niveau ,@Param("thematique") String thematique);

}
