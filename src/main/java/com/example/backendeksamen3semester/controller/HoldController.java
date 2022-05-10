package com.example.backendeksamen3semester.controller;

import com.example.backendeksamen3semester.model.Hold;
import com.example.backendeksamen3semester.service.HoldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hold")
@CrossOrigin
public class HoldController {

    private final HoldService holdService;

    @Autowired
    public HoldController(HoldService holdService){
        this.holdService = holdService;
    }

    @PostMapping
    public ResponseEntity<Hold> createHold(@RequestBody Hold hold){
        holdService.createHold(hold);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Hold>> getHold(){
        List<Hold> holdList = holdService.getHold();
        return new ResponseEntity<>(holdList, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Hold> updateHold(@PathVariable Long id, @RequestBody Hold hold) {
        hold.setHoldId(id);
        return new ResponseEntity<>(holdService.updateHold(hold), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Hold> deleteHold(@PathVariable Long id){
        holdService.deleteHold(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
