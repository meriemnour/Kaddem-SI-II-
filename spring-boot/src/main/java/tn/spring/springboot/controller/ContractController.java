package tn.spring.springboot.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.spring.springboot.entity.Contrat;
import tn.spring.springboot.entity.Etudiant;
import org.springframework.web.bind.annotation.RestController;
import tn.spring.springboot.service.IContractService;

import java.util.List;
@AllArgsConstructor
@Tag(name = "Contrat Management")
@RestController
public class ContractController {
    /*@Autowired
    IContractService iContractService;


    @GetMapping("/getC")
    public List<Contrat> GetC(){

        return  iContractService.getContract();
    }

    @PostMapping("/addC")
    public void  addContrat(@RequestBody Contrat C){
        iContractService.addContract(C);
    }

    @PutMapping("/putC/{idContrat}")
    public void updateC(@PathVariable("idContrat") int id, @RequestBody Contrat C){

        C.setIdContrat(id);
        iContractService.updateContract(C);
    }

    @DeleteMapping("/delC/{idContrat}")
    public  void deleteC(@PathVariable("idContrat") int id){

        iContractService.deleteContract(id);
    }*/


    @Autowired
    IContractService contratService;

    @RequestMapping("/operateur")
    @Operation(description = "afficher tout les contrats")
    @GetMapping("")
    public List<Contrat> GetC(){

        return  contratService.getAllContrat();
    }

    @Operation(description = "ajouter tout les contrats")
    @PostMapping("/addC")
    public void  addC(@RequestBody Contrat C){
        contratService.addContrat(C);
    }


    @Operation(description = "modifier tout les contrats")
    @PutMapping("/putC/{idContrat}")
    public void updateC(@PathVariable("idContrat") int id, @RequestBody Contrat C){

        C.setIdContrat(id);
        contratService.updateContrat(C);
    }

    @Operation(description = "supprimer tout les contrats")
    @DeleteMapping("/delC/{idContrat}")
    public  void deleteC(@PathVariable("idContrat") int id){

        contratService.deleteContrat(id);
    }



}
