package net.javaguides.springbootbackend.service;
import lombok.RequiredArgsConstructor;
import net.javaguides.springbootbackend.model.Stagiaire;
import net.javaguides.springbootbackend.repository.StagiaireRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@RequiredArgsConstructor
@Service
public class StagiaireService {
    private final  StagiaireRepository stagiaireRepository;



    public Stagiaire postStagiaire(Stagiaire stagiaire){

        return stagiaireRepository.save(stagiaire);

    }
    public List<Stagiaire> getAllStagiaire(){
        return stagiaireRepository.findAll();
    }
    public Stagiaire getStagiaireById(Long id){
        return stagiaireRepository.findById(id).orElse(null);

    }
    public Stagiaire updateStagiaire(Stagiaire stagiaire){
        return  stagiaireRepository.save(stagiaire);
    }
    public void deleteStagiaire(Long id){
        stagiaireRepository.deleteById(id);
    }
   
}
