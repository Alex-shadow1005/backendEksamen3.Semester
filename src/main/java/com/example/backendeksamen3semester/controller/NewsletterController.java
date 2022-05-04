package com.example.backendeksamen3semester.controller;

import com.example.backendeksamen3semester.model.Newsletter;
import com.example.backendeksamen3semester.repository.NewsletterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
public class NewsletterController {

    @Autowired
    NewsletterRepository newsletterRepository;

    @GetMapping("/sendnewsletter")
    public List<Newsletter> getAllMails(){ return newsletterRepository.findAll(); }


    @PostMapping("/createemail")
    @ResponseStatus(HttpStatus.CREATED)
    public Newsletter createEmail(@RequestBody Newsletter newsletter){
        System.out.println("Email has been added to our newsletter list! :)");
        return newsletterRepository.save(newsletter);
    }

    @PutMapping("/updateemail/{newsletterid}")
    public ResponseEntity<Newsletter> updateEmail(@PathVariable Integer newsletterid, @RequestBody Newsletter newsletter){
        Optional<Newsletter> optEmail = newsletterRepository.findById(newsletterid);
        if (optEmail.isPresent()){
            newsletterRepository.save(newsletter);
            return new ResponseEntity<Newsletter>(newsletter, HttpStatus.OK);
        } else {
            Newsletter notFound = new Newsletter();
            notFound.setEmail("Email med id " + newsletterid + " kunne ikke findes");
            return new ResponseEntity<Newsletter>(notFound, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/deleteemail/{newsletterid}")
    public ResponseEntity<String> deleteEmail(@PathVariable Integer newsletterid) {
        try {
            newsletterRepository.deleteById(newsletterid);
            return new ResponseEntity<>("Email med id " + newsletterid + " er blevet slettet", HttpStatus.OK);
        } catch (Exception err){
            return new ResponseEntity<>("Email med id " + newsletterid + " kunne ikke slettes", HttpStatus.NOT_FOUND);
        }
    }
}
