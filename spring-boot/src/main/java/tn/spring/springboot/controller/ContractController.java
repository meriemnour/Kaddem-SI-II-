package tn.spring.springboot.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import tn.spring.springboot.entity.Contrat;
import tn.spring.springboot.entity.Etudiant;
import org.springframework.web.bind.annotation.RestController;
import tn.spring.springboot.service.IContractService;

import java.util.Date;
import java.util.List;
@AllArgsConstructor
@Tag(name = "Contrat Management")
@RestController
@RequestMapping("/contrat")
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


    @Operation(description="affichage liste des contrats par l'id universite")
    @GetMapping("/get")
    @ResponseBody
    public List<Contrat> get(){
        return contratService.OrderBy();
    }

    @GetMapping("/getChiffreAffaireEntreDeuxDate/{start}/{end}")
    float getChiffreAffaireEntreDeuxDate(@PathVariable("start") @DateTimeFormat(pattern = "yyyy-MM-dd") Date start,
                                         @PathVariable("end")  @DateTimeFormat(pattern = "yyyy-MM-dd") Date end)
    {
        return contratService.getChiffreAffaireEntreDeuxDate(start,end);
    }


    @GetMapping("/contratBetween2dates/{start}/{end}")
    List<Contrat> contratBetween2Dates(@PathVariable("start")@DateTimeFormat(pattern="yyyy-MM-dd") Date start,
                                       @PathVariable("end")@DateTimeFormat(pattern="yyyy-MM-dd") Date end)
    {
        return contratService.contratBetween2dates(start,end);
    }

    @GetMapping("/nbrContratsValides/{end}/{start}")
    Integer nbContratValides(@PathVariable("end")@DateTimeFormat(pattern="yyyy-MM-dd")Date end,
                             @PathVariable("strat")@DateTimeFormat(pattern="yyyy-MM-dd")Date start)
    {
        return contratService.nbContratsValides(end,start);
    }


    @GetMapping("/contratExp")
    List<Contrat> contratExp()
    {
        return contratService.dateExp();
    }

    @GetMapping("/contratDeapssAn")
    List<Contrat> contraDepassAn()
    {
        return contratService.ContratDepassAn();
    }

























}
