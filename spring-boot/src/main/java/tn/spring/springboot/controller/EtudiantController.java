package tn.spring.springboot.controller;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.spring.springboot.entity.Etudiant;
import tn.spring.springboot.entity.Option;
import tn.spring.springboot.service.IEtudiantService;

import java.util.List;
@Tag(name = "Etudiant Management")
@RestController
public class EtudiantController {
   /* @Autowired
    IEtudiantService iEtudiantService;




    // Save operation
    @PostMapping("/save-etudiands")
    @ResponseBody
    public Etudiant addEtudiant(@RequestBody Etudiant etudiant)
    {
        Etudiant e = iEtudiantService.addEtudiant(etudiant);
        return e;
    }

    @GetMapping("/retrieve-etudiant/{idEtudiant}")
    @ResponseBody
    public Etudiant getEtudiant(@PathVariable("idEtudiant") Integer idEtudiant)
    {
        return iEtudiantService.retrieveEtudiant(idEtudiant);
    }

    @DeleteMapping("/delete-etudiant/{idEtudiant}")
    @ResponseBody
    public Etudiant deleteEtudiant(@PathVariable("idEtudiant") Integer idEtudiant)
    {
        iEtudiantService.removeEtudiant(idEtudiant);
        return null;
    }

    @PutMapping("update-etudiant")
    @ResponseBody
    public Etudiant updateEtudiant(@RequestBody Etudiant etudiant)
    {
        return iEtudiantService.updateEtudiant(etudiant);
    }


    @GetMapping("/retrieve-all-etudiants")
    @ResponseBody

    public List<Etudiant> getEtudiants()
    {
        return iEtudiantService.retrieveAllEtudiants();
    }*/

    @Autowired
    IEtudiantService etudiantService;


    @GetMapping("/getone/{idEtudiant}")
    public Etudiant getEtudiantbyid(@PathVariable("idEtudiant") int id){

        return  etudiantService.getEtudiantbyid(id);
    }
    @Operation(description = "afficher tout les  etudiant")
    @RequestMapping("operateurE")
    @GetMapping("/getall")
    public List<Etudiant>GetEtudiant(){

        return  etudiantService.getAllEtudiant();
    }

    @Operation(description = "ajouter tout les  etudiant")
    @PostMapping("/addetude")
    public void addEtude(@RequestBody Etudiant E){

        etudiantService.addEtudiant(E);
    }


    @Operation(description = "modifier tout les  etudiant")
    @PutMapping("/put/{idEtudiant}")
    public void updateEtud(@PathVariable("idEtudiant") int id, @RequestBody Etudiant E){

        E.setIdEtudiant(id);
        etudiantService.updateEtudiant(E);
    }

    @Operation(description = "supprimer tout les  etudiant")
    @DeleteMapping("/del/{idEtudiant}")
    public  void deleteEtud(@PathVariable("idEtudiant") int id){

        etudiantService.deleteEtudiant(id);
    }

    @GetMapping("/find/{prenom}")
    public Etudiant findEtd(@PathVariable("prenom") String prenom){
        return etudiantService.findEtudiantByprenom(prenom);
    }
    @PutMapping("/putq/{option}/{idEtudiant}")
    public void updateEtudq(@PathVariable("option") Option option, @PathVariable("idEtudiant") int id){

        etudiantService.updateEtudiantByOption(option,id);
    }


    /*@GetMapping("/findQuery/{thematique}")
    public List<Etudiant> findEtdQuery(@PathVariable("thematique") String th){
        return etudiantService.retrieveEtudiantByEquipeThematique(th);
    }

    @PutMapping("/AsignE/{idEtudiant}/{idDepart}")
    public  void assignEtudtoDep(@PathVariable("idEtudiant") int idEtudiant,@PathVariable("idDepart") int idDepart){
        etudiantService.AssignEtudtoDepartement(idEtudiant,idDepart);
    }*/

}
