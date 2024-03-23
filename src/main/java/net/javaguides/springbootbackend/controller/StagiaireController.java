package net.javaguides.springbootbackend.controller;

import lombok.RequiredArgsConstructor;
import net.javaguides.springbootbackend.model.Stagiaire;
import net.javaguides.springbootbackend.service.StagiaireService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;


@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@CrossOrigin("*")
public class StagiaireController {

    private final StagiaireService stagiaireService;

    @PostMapping("/stagiaire")
    public Stagiaire postStagiaire(@RequestBody Stagiaire stagiaire) {

        return stagiaireService.postStagiaire(stagiaire);
    }

    @GetMapping("/stagiaires")
    private List<Stagiaire> getAllStagiaire(){
        return stagiaireService.getAllStagiaire();
    }

    @GetMapping("/stagiaire/{id}")
    public ResponseEntity<Stagiaire> getStagiaireById(@PathVariable Long id){
        Stagiaire stagiaire = stagiaireService.getStagiaireById(id);
        if (stagiaire == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(stagiaire);
    }
    @PutMapping("/stagiaire/{id}")
    public ResponseEntity<Stagiaire> updateStagiaire(@PathVariable Long id,@RequestBody Stagiaire stagiaire){
        Stagiaire existingStagiaire = stagiaireService.getStagiaireById(id);
        if (existingStagiaire == null)
            return ResponseEntity.notFound().build();
        existingStagiaire.setName(stagiaire.getName());
        existingStagiaire.setEmail(stagiaire.getEmail());
        existingStagiaire.setPhone(stagiaire.getPhone());
        Stagiaire  updateStagiaire = stagiaireService.updateStagiaire(existingStagiaire);
        return ResponseEntity.ok(updateStagiaire);

    }
    @DeleteMapping("/stagiaire/{id}")
    public ResponseEntity<?> deleteStagiaire(@PathVariable Long id){
        Stagiaire existingStagiaire = stagiaireService.getStagiaireById(id);
        if (existingStagiaire == null)
            return ResponseEntity.notFound().build();
        stagiaireService.deleteStagiaire(id);
        return ResponseEntity.ok().build();
    }


}
