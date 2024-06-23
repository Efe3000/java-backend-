package be.ucll.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import be.ucll.model.Publication;
import be.ucll.repository.PublicationRepository;

@Service
public class PublicationService {
 private PublicationRepository publicationRepository;

@Autowired
 public PublicationService(PublicationRepository publicationRepository){
    this.publicationRepository = publicationRepository;

 }
 public List<Publication> getAllPublications(){
    return publicationRepository.findAll();

}

 public List<Publication>findPublicationsByTitleAndType(String title, String type){
    List<Publication> pubs = new ArrayList<>();

        String lowerSearchTitle = title.toLowerCase(); // Convert search title to lowercase

        for (Publication pub : publicationRepository.findAll()) {
            String lowerTitle = pub.getTitle().toLowerCase(); // Convert publication title to lowercase

            // Check if the publication title contains the search title (case-insensitive) and the type matches
            if (lowerTitle.contains(lowerSearchTitle) || pub.getType().equalsIgnoreCase(type)) {
                pubs.add(pub);
            }
        }
            // if after iterating through the loop and no search was found then we return an empty list
            if (pubs.isEmpty()) {
                new ArrayList<>();
            }

        return pubs;
    }


    public List<Publication> returnAvailableCopies (int copies){
        List<Publication> pubs = new ArrayList<>();
      
        for(Publication i: publicationRepository.findAll()){
        if(i.getAvailableCopies() >= copies ){
            pubs.add(i);
        }
        
        }
        if(pubs.isEmpty()){
            new ArrayList<>();
        }
      
      return pubs;

    }
      

    












}
