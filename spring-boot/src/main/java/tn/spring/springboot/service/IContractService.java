package tn.spring.springboot.service;

import tn.spring.springboot.entity.Contrat;

import java.util.List;

public interface IContractService {
    /*boolean updateContract(Contrat c ) ;
    boolean deleteContract(int c ) ;
    int addContract(Contrat c ) ;
    Contrat getContract(int contrat) ;
    List<Contrat> getContract( ) ;
   // List<Contrat> getAllContrat();*/

    void addContrats(Contrat C);
    List<Contrat> getAllContrat();
    Contrat addContrat(Contrat C);
    Contrat updateContrat(Contrat C);
    void deleteContrat(int id);
    Contrat getContratbyid(int id);

    List<Contrat> findById(int id);

    List<Contrat> OrderBy();
}
