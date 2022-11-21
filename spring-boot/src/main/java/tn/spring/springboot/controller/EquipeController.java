package tn.spring.springboot.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.spring.springboot.entity.Equipe;
import tn.spring.springboot.entity.Niveau;
import tn.spring.springboot.service.IEquipeService;

import java.util.List;
@Tag(name = "Equipe Management")
@RestController
public class EquipeController {
    /*@Autowired
    IEquipeService iEquipeService;*/
    @Autowired
    IEquipeService iEquipeService;

    @Operation(description = "afficher tout les  equipe")
    @GetMapping("/Eqp")
    public List<Equipe> Geteqp(){

        return  iEquipeService.getAlleqp();
    }

    @Operation(description = "ajouter tout les  equipe")
    @PostMapping("/addEquipe")
    public void  addEqp(@RequestBody Equipe D){
        iEquipeService.addeqp(D);
    }


    @Operation(description = "modifier tout les  equipe")
    @PutMapping("/putEquipe/{IdEquipe}")
    public void updateEqp(@PathVariable("IdEquipe") int id, @RequestBody Equipe C){

        C.setIdEquipe(id);
        iEquipeService.updateeqp(C);
    }


    @Operation(description = "supprimer tout les  equipe")
    @DeleteMapping("/delDetEquipe/{IdEquipe}")
    public  void deleteEqp(@PathVariable("IdEquipe") int id){

        iEquipeService.deleteeqp(id);
    }

    @GetMapping("/findIdEtudiant/{idEtudiant}")
    public List<Equipe> findEtudiantbyPrenom(@PathVariable("idEtudiant") int id){

        return  iEquipeService.findEquipesByEtudiantsIdEtudiant(id);
    }
    @GetMapping("/findTH/{thematique}")
    public List<Equipe> findbyTH(@PathVariable("thematique") String thematique){

        return  iEquipeService.findEquipeByDetailEquipe1ThematiqueLike(thematique);
    }
    @GetMapping("/findzouz/{idEtudiant}/{idDepart}")
    public List<Equipe> findbyzouz(@PathVariable("idEtudiant") int id1,@PathVariable("idDepart") int id2){

        return  iEquipeService.findEquipesByEtudiantsIdEtudiantAndEtudiantsDepartementIdDepart(id1,id2);
    }
    @GetMapping("/findnon/{idEtudiant}")
    public List<Equipe> findNon(@PathVariable("idEtudiant") int id1){

        return  iEquipeService.findEquipesByEtudiantsIdEtudiantAndDetailEquipe1ThematiqueNotNull(id1);
    }

    @DeleteMapping("/delQ/{niveau}")
    public  void  DelEqp(@PathVariable Niveau niveau){
        iEquipeService.deleteEquipeByNiveau(niveau);
    }

    @GetMapping("/EqpQ/{niveau}/{thematique}")
    public List<Equipe> GeteqpQu(@PathVariable Niveau niveau, @PathVariable String thematique){

        return  iEquipeService.retriveEquipeByNiveauAndThematique(niveau,thematique);
    }


   /*@GetMapping("/findIdEtudiantNonNull/{idEtudiant}")
    public List<Equipe> findEtudiantbyIdNonNull(@PathVariable("idEtudiant") int id){

        return  iEquipeService.findEquipeByEtudiantsAndDetailEquipe1ThematiqueNonNull(id);
    }*/


}
