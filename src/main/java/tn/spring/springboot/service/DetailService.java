package tn.spring.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import tn.spring.springboot.entity.Departement;
import tn.spring.springboot.entity.DetailEquipe;
import tn.spring.springboot.repository.IdetailRepository;

import java.util.List;
@Service
public class DetailService implements IDetailSercive{
    /*@Autowired
  IdetailRepository idetailRepository;

    @Override
    public List<DetailEquipe> retrieveAllDetail() {
        return (List<DetailEquipe>) idetailRepository.findAll();
    }

    @Override
    public DetailEquipe addDetail(DetailEquipe d) {
        return idetailRepository.save(d);
    }

    @Override
    public DetailEquipe updateDetail(DetailEquipe d) {
        return idetailRepository.save(d);
    }

    @Override
    public DetailEquipe retrieveDetail(Integer idDetail) {
        return idetailRepository.findById(idDetail).get();
    }*/

    @Autowired
    IdetailRepository detailEquipeRepository;

    @Override
    public List<DetailEquipe> getAlldeqp() {
        return detailEquipeRepository.findAll();
    }

    @Override
    public DetailEquipe adddeqp(DetailEquipe E) {
        return detailEquipeRepository.save(E);
    }

    @Override
    public DetailEquipe updatedeqp(DetailEquipe E) {
        return detailEquipeRepository.save(E);
    }

    @Override
    public void deletedeqp(int id) {
        detailEquipeRepository.deleteById(id);

    }

    @Override
    public DetailEquipe getdeqpbyid(int id) {
        return detailEquipeRepository.findById(id).orElse(null);
    }

    @Override
    public List<DetailEquipe> findByThematiqueLike(String thematique) {
        return detailEquipeRepository.findByThematiqueLike(thematique);
    }
}
