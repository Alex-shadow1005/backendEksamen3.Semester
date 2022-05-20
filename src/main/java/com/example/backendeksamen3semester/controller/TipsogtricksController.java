package com.example.backendeksamen3semester.controller;



import com.example.backendeksamen3semester.model.Hold;
import com.example.backendeksamen3semester.model.OmOs;
import com.example.backendeksamen3semester.model.Tipsogtricks;
import com.example.backendeksamen3semester.service.TipsogtricksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/tipsogtricks")
@CrossOrigin
public class TipsogtricksController {

    private final TipsogtricksService tipsogtricksService;

    @Autowired
    public TipsogtricksController(TipsogtricksService tipsogtricksService) {
        this.tipsogtricksService = tipsogtricksService;
    }

    @PostMapping
    public ResponseEntity<Tipsogtricks> createTipsogtricks(@RequestBody Tipsogtricks tipsogtricks) throws IOException {
        tipsogtricksService.createTipsogtricks(tipsogtricks);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public List<Tipsogtricks> getTipsogtricks() {
        return tipsogtricksService.getTipsogtricks();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tipsogtricks> updateTipsogtricks(@PathVariable Long id, @RequestBody Tipsogtricks tipsogtricks) {
        tipsogtricks.setTipsogtricksId(id);
        return new ResponseEntity<>(tipsogtricksService.updateTipsogtricks(tipsogtricks), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Tipsogtricks> deleteTipsogtricks(@PathVariable Long id){
        tipsogtricksService.deleteTipsogtricks(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }



}
