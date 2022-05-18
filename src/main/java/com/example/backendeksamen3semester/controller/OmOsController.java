package com.example.backendeksamen3semester.controller;

import com.example.backendeksamen3semester.model.OmOs;
import com.example.backendeksamen3semester.service.OmOsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/omos")
@CrossOrigin
public class OmOsController {

    private final OmOsService omOsService;

    @Autowired
    public OmOsController(OmOsService omOsService) {
        this.omOsService = omOsService;
    }

    @PostMapping
    public ResponseEntity<OmOs> createOmOs(@RequestBody OmOs omOs){
        omOsService.createOmOs(omOs);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<OmOs>> getOmOs(){
        List<OmOs> omOsList = omOsService.getOmOs();
        return new ResponseEntity<>(omOsList, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OmOs> updateOmOs(@PathVariable Long id, @RequestBody OmOs omOs) {
        omOs.setOmOsId(id);
        return new ResponseEntity<>(omOsService.updateOmOs(omOs), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<OmOs> deleteOmOs(@PathVariable Long id){
        omOsService.deleteOmOs(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
