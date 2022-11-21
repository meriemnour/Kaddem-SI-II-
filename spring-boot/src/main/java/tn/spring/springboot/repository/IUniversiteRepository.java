package tn.spring.springboot.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import tn.spring.springboot.entity.Universite;
@Repository
@Component
public interface IUniversiteRepository  extends JpaRepository<Universite, Integer> {
}
