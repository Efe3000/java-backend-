package be.ucll.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import be.ucll.model.Publication;

@Repository
public interface PublicationRepository extends JpaRepository<Publication, Long> {
    public List<Publication> findAll();

    public List<Publication> findByType(String type);

    public List<Publication> findByTitleContainsIgnoreCase(String title);

    public List<Publication> findByTypeAndTitleContainsIgnoreCase(String type, String title);

    public List<Publication> findByAvailableCopies(int availableCopies);

    
}
