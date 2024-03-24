package net.javaguides.springbootbackend.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import net.javaguides.springbootbackend.model.Stagiaire;
import net.javaguides.springbootbackend.service.StagiaireService;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@CrossOrigin("*")
public class StagiaireController {

    private final StagiaireService stagiaireService;

    @PostMapping("/stagiaire")
    public ResponseEntity<?> postStagiaire(@RequestBody Stagiaire stagiaire) {
        Stagiaire newStagiaire = stagiaireService.postStagiaire(stagiaire);
        if (newStagiaire != null) {
            return ResponseEntity.ok().body(newStagiaire); // Retourner le stagiaire créé
        } else {
            return ResponseEntity.badRequest().body("La création du stagiaire a échoué.");
        }
    }

    @GetMapping("/stagiaires")
    public ResponseEntity<List<Stagiaire>> getAllStagiaire() {
        List<Stagiaire> stagiaires = stagiaireService.getAllStagiaire();
        return ResponseEntity.ok(stagiaires);
    }

    @GetMapping("/stagiaireEmail/{email}")
    public ResponseEntity<Stagiaire> getStagiaireEmail(@PathVariable String email) {
        Stagiaire stagiaires = stagiaireService.FindByEmail(email);
        return ResponseEntity.ok(stagiaires);
    }

    @GetMapping("/stagiaire/{id}")
    public ResponseEntity<?> getStagiaireById(@PathVariable Long id) {
        Stagiaire stagiaire = stagiaireService.getStagiaireById(id);
        if (stagiaire != null) {
            return ResponseEntity.ok(stagiaire);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/stagiaire/{id}")
    public ResponseEntity<?> updateStagiaire(@PathVariable Long id, @RequestBody Stagiaire stagiaire) {
        Stagiaire existingStagiaire = stagiaireService.getStagiaireById(id);
        if (existingStagiaire != null) {
            existingStagiaire.setName(stagiaire.getName());
            existingStagiaire.setEmail(stagiaire.getEmail());
            existingStagiaire.setPhone(stagiaire.getPhone());
            Stagiaire updatedStagiaire = stagiaireService.updateStagiaire(existingStagiaire);
            return ResponseEntity.ok().body("Stagiaire mis à jour avec succès.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/stagiaire/{id}")
    public ResponseEntity<?> deleteStagiaire(@PathVariable Long id) {
        Stagiaire existingStagiaire = stagiaireService.getStagiaireById(id);
        if (existingStagiaire != null) {
            stagiaireService.deleteStagiaire(id);
            return ResponseEntity.ok().body("Stagiaire supprimé avec succès.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}