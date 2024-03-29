package net.javaguides.springbootbackend.repository;

import net.javaguides.springbootbackend.model.DemandeStagiaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DemandeStagiaireRepository extends JpaRepository<DemandeStagiaire, Long> {

}
