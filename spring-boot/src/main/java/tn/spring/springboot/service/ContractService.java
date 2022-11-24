package tn.spring.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.spring.springboot.entity.Contrat;
import tn.spring.springboot.repository.IContractRepository;
import tn.spring.springboot.repository.IUniversiteRepository;

import java.util.List;

@Service
public class ContractService implements IContractService{

    /*@Autowired


    @Override
    public boolean updateContract(Contrat c) {
        return false;
    }

    @Override
    public boolean deleteContract(int c) {
        iContractRepository.deleteById(c);
        return false;
    }

    @Override
    public int addContract(Contrat c) {
        return iContractRepository.save(c).getIdContrat();
    }

    @Override
    public Contrat getContract(int contratc) {
        return (Contrat) iContractRepository;
    }

    @Override
    public List<Contrat> getContract() {
        return null;
    }*/



    @Autowired
    IContractRepository contratRepository;

    @Override
    public List<Contrat> getAllContrat() {

        //liste itérable
        //najem naamel forçage bel cast twali : (List<Contrat>)contratRepository.findAll()
        return contratRepository.findAll();
    }

    @Override
    public Contrat addContrat(Contrat E) {

        return contratRepository.save(E);
    }
   /* 2ème méthode d'ajout
    @Override
    public void addContrat(Contrat E) {

         contratRepository.save(E);
    }*/
   @Override
   public void addContrats(Contrat C) {
       contratRepository.save(C);
   }
    @Override
    public Contrat updateContrat(Contrat E) {return contratRepository.save(E);}

    /* 2ème méthode de modifier
      @Override
    public void updateContrat(Contrat E) { contratRepository.save(E);}

     */
    @Override
    public void deleteContrat ( int id){
        /* 1ère méthode
        Contrat contratRepository.findById(id).orElse(null);
        contratRepository.delet(Contrat);
        */

        contratRepository.deleteById(id);
    }


    @Override
    public Contrat getContratbyid ( int id){
        return contratRepository.findById(id).orElse(null);
    }

    @Override
    public List<Contrat> findById(int id) {
        return null;
    }

    public List<Contrat> OrderBy()
    {
        return contratRepository.retrieveContratByIdUni ();
    }

}
