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


    List<Etudiant> findByDepartement(Integer idDepart);

    @Query("select e from Etudiant e where e.nom=?1 and e.prenom=?2 ")
    Etudiant findEtudiantByNomPrenom(String nom,String prenom);

    //List<Etudiant> findByPrenomENotNull();
 /*   @Query("select e from Etudiant e where e.nomE=?1 and e.prenomE=?2")
    Etudiant findEtudiantByNomAndPrenom(String nom, String prenom);
    List<Etudiant> findAllByOption(Option p);
    //hedhii
    @Query("select e from Etudiant e where e.departement.nomDepart=:nomDepart")
    List<Etudiant> retrieveStudentByDepart(@Param("nomDepart") String nomDepartement);
    //wala hedhi
    @Query("select e from Etudiant e inner join e.departement.nomDepart=:nomDepart")
    List<Etudiant> byDepart(@Param("nomDepart") String nomDepartement);
    @Query("select e from Etudiant e inner join e.departement ee where ee.nomDepart = ?1")
    List<Etudiant> findEtudiantByDepartement(String nomDep);*/
    @Query("select e from Etudiant e inner join e.departement ee where ee.idDepart = ?1")
    List<Etudiant> findEtudiantByDepartement    (Integer idDepart);


}
