package tn.esprit.user.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.user.entities.Niveau;
import tn.esprit.user.services.Implementations.NiveauException;
import tn.esprit.user.services.Interfaces.INiveauService;
import java.util.List;

@RestController
@RequestMapping("/niveau")
@CrossOrigin(origins = "http://localhost:4200")
public class NiveauController {
    @Autowired
    INiveauService iNiveauService;
    @PostMapping(value = "/addNiveau")
    private ResponseEntity<?> addNiveau(@RequestBody Niveau niveau) {
        try {
            Niveau newNiveau = iNiveauService.addNiveau(niveau);
            return ResponseEntity.ok(newNiveau);
        } catch (NiveauException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
    @PutMapping("/updateNiveau/{id_niveau}")
    public ResponseEntity<?> updateNiveau(@PathVariable String id_niveau, @RequestBody Niveau niveau) {
        try {
            Niveau updateNiveau = iNiveauService.updateNiveau(id_niveau, niveau);
            return ResponseEntity.ok(updateNiveau);
        } catch (NiveauException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
    @GetMapping("/getAllNiveaux")
    public List<Niveau> getAllNiveau() {
        List<Niveau> niveaux = iNiveauService.getAllNiveau();
        return niveaux;
    }
    @GetMapping("/getNiveau/{id_niveau}")
    public Niveau getNiveauById(@PathVariable String id_niveau){
        return  iNiveauService.getNiveauById(id_niveau);
    }
    @DeleteMapping("/delete/{id_niveau}")
    public void deleteNiveauById(@PathVariable String id_niveau){
        iNiveauService.deleteNiveau(id_niveau);
    }
}
