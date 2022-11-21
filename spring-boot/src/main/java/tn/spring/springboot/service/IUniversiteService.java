package tn.spring.springboot.service;
import tn.spring.springboot.entity.Universite;

import java.util.List;

public interface IUniversiteService {
   /* List<Universite> retrieveAllUniversites();

    Universite addUniversite (Universite u);

    Universite updateUniversite (Universite u);

    Universite retrieveUniversite (Integer idUniversite);*/
   List<Universite> getAllUniv();
    Universite addUniv(Universite U);
    Universite updateUni(Universite U);
    void deleteUni(int id);
    Universite getUnid(int id);
    public void assignDepartToUni(int idU,int dep);
}
