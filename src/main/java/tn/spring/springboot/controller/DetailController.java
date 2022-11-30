package tn.spring.springboot.controller;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import tn.spring.springboot.entity.DetailEquipe;
import tn.spring.springboot.service.IDerpartementService;
import tn.spring.springboot.service.IDetailSercive;

import java.util.List;
@Tag(name = "Detail Equipe Management")
@RestController
public class DetailController {
    /*@Autowired
    IDetailSercive iDetailSercive;*/


    @Autowired
    IDetailSercive detailEquipeService;

    @Operation(description = "afficher tout les detail equipe")
    @GetMapping("/getDetEquipe")
    public List<DetailEquipe> GetDetEqp(){

        return  detailEquipeService.getAlldeqp();
    }

    @Operation(description = "ajouter tout les detail equipe")
    @PostMapping("/addDetEquipe")
    public void  addDetEqp(@RequestBody DetailEquipe D){
        detailEquipeService.adddeqp(D);
    }


    @Operation(description = "modifier tout les detail equipe")
    @PutMapping("/putDetEquipe/{IdEquipe}")
    public void updateDetEqp(@PathVariable("IdEquipe") int id, @RequestBody DetailEquipe C){

        C.setIdEquipe(id);
        detailEquipeService.updatedeqp(C);
    }

    @Operation(description = "supprimer tout les detail equipe")
    @DeleteMapping("/delDetEquipe/{IdEquipe}")
    public  void deleteDetEqp(@PathVariable("IdEquipe") int id){

        detailEquipeService.deletedeqp(id);
    }
    @GetMapping("/getth/{thematique}")
    public List<DetailEquipe>findbyThem(@PathVariable("thematique") String Theme){
        return  detailEquipeService.findByThematiqueLike(Theme);
    }
}
