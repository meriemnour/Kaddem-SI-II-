package tn.spring.springboot.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import tn.spring.springboot.entity.Etudiant;
import tn.spring.springboot.entity.Option;

import java.util.List;

@Repository
@Component
public interface IEtudiantRepository extends JpaRepository<Etudiant, Integer> {

    Etudiant findEtudiantByprenom(String prenom) ;

    @Modifying
    @Transactional
    @Query(" update Etudiant set option = :op where idEtudiant = :idEtudiant")
    void updateEtudiantByOption(@Param("op") Option op , @Param("idEtudiant") int idEtudiant);


    @Query("SELECT etudiant FROM Etudiant etudiant"
            + " INNER JOIN etudiant.equipes equipe"
            + " INNER JOIN DetailEquipe detail"
            + " ON detail.IdEquipe = equipe.idEquipe"
            + " where detail.thematique= :thematique")
    List<Etudiant> retrieveEtudiantByEquipeThematique (@Param("thematique") String thematique);





}
