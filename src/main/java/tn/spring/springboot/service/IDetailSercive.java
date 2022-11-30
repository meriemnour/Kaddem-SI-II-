package tn.spring.springboot.service;

import tn.spring.springboot.entity.DetailEquipe;

import java.util.List;

public interface IDetailSercive {
 /*   List<DetailEquipe> retrieveAllDetail();

    DetailEquipe addDetail (DetailEquipe d);

    DetailEquipe updateDetail(DetailEquipe d);

    DetailEquipe retrieveDetail (Integer idDetail);*/

    List<DetailEquipe> getAlldeqp();
    DetailEquipe adddeqp(DetailEquipe E);
    DetailEquipe updatedeqp(DetailEquipe E);
    void deletedeqp(int id);
    DetailEquipe getdeqpbyid(int id);
    List<DetailEquipe> findByThematiqueLike (String thematique);
}
