package tn.spring.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.spring.springboot.entity.Contrat;
import tn.spring.springboot.entity.Specialite;
import tn.spring.springboot.repository.IContractRepository;
import tn.spring.springboot.repository.IUniversiteRepository;

import java.util.Date;
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




    @Override
    public float getChiffreAffaireEntreDeuxDate(Date startDate, Date endDate) {
        List<Contrat> listContrat=contratRepository.contratBetween2dates(startDate,endDate);
        System.out.println(listContrat);
        float chiffre=0;
        for( Contrat c:listContrat){
            if(c.getSpecialite().equals(Specialite.IA)){
                chiffre=chiffre+300;
            }
            else if (c.getSpecialite().equals(Specialite.RESEAUX)){
                chiffre=chiffre+350;
            }
            else if(c.getSpecialite().equals(Specialite.CLOUD)){
                chiffre=chiffre+400;
            }
            else if (c.getSpecialite().equals(Specialite.SECURITE)){
                chiffre=chiffre+450;
            }
        }
        return chiffre;
    }

    @Override
    public List<Contrat> contratBetween2dates(Date startDate, Date endDate) {
        return  contratRepository.contratBetween2dates(startDate,endDate);
    }
    @Override
    public Integer nbContratsValides(Date endDate, Date startDate) {
        return contratRepository.countContratByDateDebutContratAfterAndDateFinContratBefore(endDate,startDate);
    }

    @Override
    public List<Contrat> dateExp() {
        return contratRepository.dateExp();
    }

    @Override
    public List<Contrat> ContratDepassAn() {
        return contratRepository.contratDepassAn();
    }

    @Scheduled(cron = "*/60 * * * * * ")
    public String retrieveStatusContrat()
    {
        List<Contrat> contrats=contratRepository.dateExp();
        String string = "les contrats concernés tous les 15 jours :";
        for (Contrat c : contrats){
            string=string+"contrat id :"+c.getIdContrat()+"\n";
            string=string+"contrat date fin :"+c.getDateFinContrat()+"\n";
            string=string+"contrat debut date "+c.getDateDebutContrat()+"\n";
            string =string+"specialité"+c.getSpecialite()+"\n";

        }
        System.out.println(string);
        return string;
    }

}
