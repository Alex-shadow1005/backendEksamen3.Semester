package com.example.backendeksamen3semester.controller;

import com.example.backendeksamen3semester.model.Hold;
import com.example.backendeksamen3semester.model.Nyhed;
import com.example.backendeksamen3semester.service.NyhedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/nyhed")
@CrossOrigin
public class NyhedController {

    private final NyhedService nyhedService;

    @Autowired
    public NyhedController(NyhedService nyhedService){
        this.nyhedService = nyhedService;
    }

    @PostMapping
    public ResponseEntity<Nyhed> createNyhed(@RequestBody Nyhed nyhed){
        nyhedService.createNyhed(nyhed);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Nyhed>> getNyheder(){
        List<Nyhed> nyhedsList = nyhedService.getNyheder();
        return new ResponseEntity<>(nyhedsList, HttpStatus.OK);
    }
}
