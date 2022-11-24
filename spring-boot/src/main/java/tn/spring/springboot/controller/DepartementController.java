package tn.spring.springboot.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import tn.spring.springboot.entity.Contrat;
import tn.spring.springboot.entity.Departement;
import tn.spring.springboot.entity.Option;
import tn.spring.springboot.service.IDerpartementService;

import java.util.List;
@AllArgsConstructor
@Tag(name = "Departement Management")
@RestController
public class DepartementController {
   /* @Autowired
    IDerpartementService iDerpartementService;


    @GetMapping("/getD")
    public List<Departement> GetD(){

        return  iDerpartementService.getDepartement();
    }

    @PostMapping("/addD")
    public void  addDepartement(@RequestBody Departement D){
        iDerpartementService.addDepartement(D);
    }

    @PutMapping("/putC/{idDepart}")
    public void updateC(@PathVariable("idDepart") int id, @RequestBody Departement D){

        D.setIdDepart(id);
        iDerpartementService.updateDepartement(D);
    }

    @DeleteMapping("/delC/{idDepart}")
    public  void deleteC(@PathVariable("idDepart") int id){

        iDerpartementService.retrieveDepartement(id);
    }*/



    @Autowired
    IDerpartementService iDepartementService;

    @Operation(description = "afficher tout les departements")
    @GetMapping("/getD")
    public List<Departement> GetDep(){

        return  iDepartementService.getAlldep();
    }

    @Operation(description = "afficher tout les departements")
    @PostMapping("/addDep")
    public void  addD(@RequestBody Departement D){
        iDepartementService.addep(D);
    }

    @Operation(description = "modifier tout les departements")
    @PutMapping("/putDep/{idDepart}")
    public void updateD(@PathVariable("idDepart") int id, @RequestBody Departement C){

        C.setIdDepart(id);
        iDepartementService.updatedep(C);
    }
    @Operation(description = "supprimer tout les departements")
    @DeleteMapping("/delDep/{idDepart}")
    public  void deleteD(@PathVariable("idDepart") int id){

        iDepartementService.deletedep(id);
    }

    @GetMapping("/getDep/{option}")
    public List<Departement> GetDepQ(@PathVariable("option" ) Option op){

        return  iDepartementService.retrieveDepartementByOptionEtudiant(op);
    }

    @PutMapping("/update/{id}/{idDep}")
    public Departement assignEtudiantToDepartement(@PathVariable("id") Integer id ,@PathVariable("idDep") Integer idDep){
        return  iDepartementService.assignEtudiantToDepartement(id,idDep);
    }
    @PutMapping("/assignUniversiteToDepartement/{idU}/{idDep}")
    public void assignUniversiteToDepartement(@PathVariable("idU") Integer idU ,@PathVariable("idDep") Integer iddep){
        iDepartementService.assignUniversiteToDepartement(idU,iddep);

    }



}
