package tn.spring.springboot;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import tn.spring.springboot.entity.*;
import tn.spring.springboot.repository.IEtudiantRepository;
import tn.spring.springboot.service.ContractService;

import java.util.*;

@SpringBootTest
public class springdbtests {
   @Autowired
    ContractService contractService;

   @MockBean
    IEtudiantRepository etudiantRepository;

    @Test
    void testajouterContrat(){
        /*Date d=new Date();
        DetailEquipe dt=new DetailEquipe();
        Departement departement =new Departement(0,"bloc c ");
        Set<Equipe> listEq = new HashSet<>();
        listEq.add(new Equipe(0,"real madrid",Niveau.EXPERT,dt,listE));
        List<Departement> listD=new ArrayList<>();
        Set<Etudiant> listE=new HashSet<>();
        Set<Contrat> listC=new  HashSet<>();
        Etudiant e=new Etudiant(1,"meriem","ghozzi", Option.SIM,departement,listC,listEq);
        listE.add(e);
        listD.add(departement);

        Contrat c = new Contrat(0,d,d,Boolean.TRUE, Specialite.SECURITE,
              );
        listC.add(c);
        contractService.addContrats(c);*/
        Date d=new Date();
        Set<Contrat> listC=new  HashSet<>();
        listC.add(Contrat.builder().idContrat(0).dateDebutContrat(d).dateFinContrat(d).archive(true).specialite(Specialite.SECURITE).build());

        Set<Equipe> listEq = new HashSet<>();
        listEq.add(Equipe.builder().idEquipe(0).nomEquipe("real").niveau(Niveau.EXPERT).build());

        Departement departement =new Departement(0,"bloc c ");

        Etudiant e=new Etudiant(1,"meriem","ghozzi", Option.SIM,departement,listC,listEq);

        //test unitaire sans excétuter le repository(sans save fel base de donnée)
        //Mockito



    }
    @Test
    void contextloads()
    {

    }
}
