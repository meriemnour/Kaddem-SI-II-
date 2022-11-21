package tn.spring.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import tn.spring.springboot.entity.DetailEquipe;

import java.util.List;

@Repository
@Component
public interface IdetailRepository extends JpaRepository<DetailEquipe, Integer> {

    List<DetailEquipe> findByThematiqueLike (String thematique);
}
