package net.javaguides.springbootbackend.controller;
import net.javaguides.springbootbackend.model.DemandeStagiaire;
import net.javaguides.springbootbackend.service.DemandeStagiaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/demandes")
public class DemandeStagiaireController {

    @Autowired
    private DemandeStagiaireService demandeStagiaireService;

    @PostMapping
    public ResponseEntity<?> createDemande(@ModelAttribute DemandeStagiaire demandeStagiaire, @RequestParam("file") MultipartFile file) {
        // Valider les données de la demande
        if (demandeStagiaire == null) {
            return ResponseEntity.badRequest().body("La demande ne peut pas être vide.");
        }

        // Enregistrer le document dans un emplacement spécifié ou en base de données
        if (file != null && !file.isEmpty()) {
            // Gérer le téléchargement du document
            // Vous pouvez enregistrer le fichier dans un emplacement spécifié ou le stocker en base de données
            // Ici, nous ne faisons que renvoyer un message de succès
            System.out.println("Document téléchargé: " + file.getOriginalFilename());
        }

        // Enregistrer la demande dans la base de données
        DemandeStagiaire savedDemande = demandeStagiaireService.saveDemande(demandeStagiaire);

        if (savedDemande != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(savedDemande);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Une erreur s'est produite lors de la création de la demande.");
        }
    }
}
