package net.javaguides.springbootbackend.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "demandes_stagiaires")
public class DemandeStagiaire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nom;

    @Column(nullable = false)
    private String prenom;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String telephone;

    @Column(name = "debut_stage", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date debutStage;

    @Column(name = "fin_stage", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date finStage;

    @Column(nullable = false)
    private String filiere;

    @Column(nullable = false)
    private String centre;

    // Ajoutez d'autres champs si nécessaire

    // Getters et setters
}
