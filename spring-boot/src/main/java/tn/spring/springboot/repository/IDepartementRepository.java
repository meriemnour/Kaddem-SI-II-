package tn.spring.springboot.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import tn.spring.springboot.entity.Departement;
import tn.spring.springboot.entity.Option;

import java.util.List;

@Repository
@Component
public interface IDepartementRepository extends JpaRepository<Departement, Integer>  {

    @Query("SELECT  departement FROM Departement  departement  , Etudiant e where departement.idDepart=e.departement.idDepart and e.option = :op")
    List<Departement> retrieveDepartementByOptionEtudiant(@Param("op") Option op);

}
