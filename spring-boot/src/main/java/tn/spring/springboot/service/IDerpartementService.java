package tn.spring.springboot.service;
import tn.spring.springboot.entity.Departement;
import tn.spring.springboot.entity.Option;

import java.util.List;

public interface IDerpartementService {
   /* Departement getDepartement(int departement) ;
    List<Departement> retrieveAllDepartements();

    Departement addDepartement (Departement d);

    Departement updateDepartement (Departement d);

    Departement retrieveDepartement (Integer idDepart);*/
   List<Departement> getAlldep();
    Departement addep(Departement D);
    Departement updatedep(Departement D);
    void deletedep(int id);
    Departement getdepbyid(int id);

    List<Departement> retrieveDepartementByOptionEtudiant( Option op);



}
