package net.javaguides.springbootbackend.service;


import net.javaguides.springbootbackend.model.DemandeStagiaire;
import net.javaguides.springbootbackend.repository.DemandeStagiaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DemandeStagiaireService {
    private final DemandeStagiaireRepository demandeStagiaireRepository;

    @Autowired
    public DemandeStagiaireService(DemandeStagiaireRepository demandeStagiaireRepository) {
        this.demandeStagiaireRepository = demandeStagiaireRepository;
    }


    public DemandeStagiaire saveDemande(DemandeStagiaire demandeStagiaire) {
        return demandeStagiaireRepository.save(demandeStagiaire);
    }
}
