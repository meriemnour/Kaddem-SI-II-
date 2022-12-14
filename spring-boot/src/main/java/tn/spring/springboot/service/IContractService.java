package tn.spring.springboot.service;

import tn.spring.springboot.entity.Contrat;

import java.util.Date;
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

    float getChiffreAffaireEntreDeuxDate(Date startDate, Date endDate);
    List<Contrat> contratBetween2dates(Date startDate, Date endDate);
    Integer nbContratsValides(Date endDate, Date startDate);

    List<Contrat>dateExp();

    List<Contrat>ContratDepassAn();
}
