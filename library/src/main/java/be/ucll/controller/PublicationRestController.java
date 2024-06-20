package be.ucll.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import be.ucll.model.Publication;
import be.ucll.service.PublicationService;

@RestController
@RequestMapping("/publications")
public class PublicationRestController {

    private PublicationService publicationService;

    @Autowired
    public PublicationRestController(PublicationService publicationService){
        this.publicationService = publicationService;

    }

    @GetMapping
    public List<Publication> getAllPublications(@RequestParam (value= "title", required = false) String title, @RequestParam (value= "type", required = false) String type){
     //this took longer than usual because i implemented  if(title == null || type == null ) first
        if(title != null || type != null ){
        return publicationService.findPublicationsByTitleAndType(title, type);
     }
     else{
        return publicationService.getAllPublications();
    
     }

    }


    @GetMapping("/stock/{availableCopies}")
    public List<Publication> getAvailablePublication(@PathVariable int availableCopies){
        return publicationService.returnAvailableCopies(availableCopies);

    }







}
