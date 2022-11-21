package tn.spring.springboot.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.spring.springboot.entity.Universite;
import tn.spring.springboot.service.IUniversiteService;

import java.util.List;
@Tag(name = "Universite Management")
@RestController
public class UniversiteController {
    /*@Autowired
    IUniversiteService iUniversiteService;*/
    @Autowired
    IUniversiteService iUniversiteService;

    @Operation(description = "afficher toute les  universitess")
    @GetMapping("/allUni")
    public List<Universite> GetUni(){

        return  iUniversiteService.getAllUniv();
    }

    @Operation(description = "ajouter toute les  universitess")
    @PostMapping("/addUni")
    public void  addUniv(@RequestBody Universite D){
        iUniversiteService.addUniv(D);
    }


    @Operation(description = "modifier toute les  universitess")
    @PutMapping("/putUni/{idUni}")
    public void updateUni(@PathVariable("idUni") int id, @RequestBody Universite E){

        E.setIdUni(id);
        iUniversiteService.updateUni(E);
    }

    @Operation(description = "supprimer toute les  universitess")
    @DeleteMapping("/delUni/{idUni}")
    public  void deleteUni(@PathVariable("idUni") int id){

        iUniversiteService.deleteUni(id);
    }
    /*@PostMapping("/addUniDep/{idUni}/{idDepart}")
    public void  addUnivtoDep(@PathVariable("idUni") int idU,@PathVariable("idDepart") int id){
        iUniversiteService.assignDepartToUni(idU, id);
    }*/

}
