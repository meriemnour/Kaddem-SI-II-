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

import java.util.Date;
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


    @Query("select  count (c) from Contrat c where c.dateFinContrat<=?1 and c.dateDebutContrat>=?2")
    Integer countContratByDateDebutContratAfterAndDateFinContratBefore(Date dateFinContrat, Date dateDebutContrat);

    @Query("select  SUM(c.montant) from Contrat c where c.dateFinContrat<=?2 and c.dateDebutContrat>=?1")
    float getChiffreAffaireEntreDeuxDate(Date startDate, Date endDate);

    @Query("select c from Contrat c where   c.dateDebutContrat>=?1 and c.dateFinContrat<=?2")
    List<Contrat> contratBetween2dates(Date startDate, Date endDate);

    @Query("select c from Contrat c where DATEDIFF(current_date,c.dateFinContrat)=-15")
    List<Contrat> dateExp();

    @Query("select c from Contrat c where DATEDIFF(c.dateFinContrat,c.dateDebutContrat)>=365")
    List<Contrat>contratDepassAn();
}
