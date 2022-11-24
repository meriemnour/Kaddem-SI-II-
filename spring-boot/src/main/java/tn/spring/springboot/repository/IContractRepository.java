package tn.spring.springboot.repository;
import org.hibernate.sql.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import tn.spring.springboot.entity.Contrat;
import tn.spring.springboot.entity.Etudiant;

import java.util.List;

@Repository
@Component
public interface IContractRepository extends JpaRepository<Contrat, Integer> {
    List<Contrat> findBySpecialite(String specialite);



 /*   @Query("SELECT c FROM Contrat c"
            + " INNER JOIN Etudiant e"
            + " ON c.etudiant.idEtudiant=e.idEtudiant"
            + " INNER JOIN Universite U"
            + " INNER JOIN Departement D"
            + " ON U.departement = e.departement.idDepart"
            + " ORDER BY u.idUni")*/
    @Query("select c from Contrat c join Universite  u on (c.etudiant.departement member u.departement) order by u.idUni")
    List<Contrat> retrieveContratByIdUni ();

}
/*
 @Query("SELECT etudiant FROM Etudiant etudiant"
            + " INNER JOIN etudiant.equipes equipe"
            + " INNER JOIN DetailEquipe detail"
            + " ON detail.IdEquipe = equipe.idEquipe"
            + " where detail.thematique= :thematique")
    List<Etudiant> retrieveEtudiantByEquipeThematique (@Param("thematique") String thematique);

SELECT    c
FROM  Contrat AS c
INNER JOIN Etudiant AS e
    ON s.StudentID = r.StudentID
INNER JOIN HallData.dbo.Halls AS h1
    ON r.HallPref1 = h1.HallID
INNER JOIN HallData.dbo.Halls AS h2
    ON r.HallPref2 = h2.HallID
INNER JOIN HallData.dbo.Halls AS h3
    ON r.HallPref3 = h3.HallID

SELECT  *
FROM    one
JOIN    two
ON      one.one_name = two.one_name
ORDER BY
        one.id
 */
