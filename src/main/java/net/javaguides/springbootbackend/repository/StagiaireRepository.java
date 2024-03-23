package net.javaguides.springbootbackend.repository;
import net.javaguides.springbootbackend.model.Stagiaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StagiaireRepository extends JpaRepository<Stagiaire, Long>{

    Stagiaire findFirstByEmail(String email);

}
