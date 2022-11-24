package tn.spring.springboot.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import tn.spring.springboot.entity.Departement;
import tn.spring.springboot.entity.Universite;

import java.util.List;

@Repository
@Component
public interface IUniversiteRepository  extends JpaRepository<Universite, Integer> {
    @Query("select e.departement from Universite e where e.idUni=?1")
    List<Departement> retrieveDepartementsByUniversite(int idUni);
}
