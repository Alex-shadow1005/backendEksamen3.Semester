package com.example.backendeksamen3semester.controller;

import com.example.backendeksamen3semester.Utils.ImageUtility;
import com.example.backendeksamen3semester.model.Hold;
import com.example.backendeksamen3semester.repository.HoldRepository;
import com.example.backendeksamen3semester.service.HoldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/hold")
@CrossOrigin
public class HoldController {

    private final HoldService holdService;

    @Autowired
    public HoldController(HoldService holdService){
        this.holdService = holdService;
    }

    @PostMapping("/upload/image")
    public ResponseEntity<Hold> createHold(@RequestParam("name") String name, @RequestParam("underOverskrift") String underOverskrift, @RequestParam("tekst") String tekst, @RequestParam("pris") String pris, @RequestParam("antalKursister") int antalKursister, @RequestParam("holdImage") MultipartFile holdImage) throws IOException {
        holdService.createHold(name, underOverskrift, tekst, pris, antalKursister, holdImage);
        return new ResponseEntity<>(HttpStatus.OK);

    }

    @GetMapping
    public List<Hold> getHold(){
        return holdService.getallHold();
    }

    @GetMapping("/get/image/{name}")
    public ResponseEntity<byte[]> getImage(@PathVariable("name") String name) throws IOException {
        final Optional<Hold> hold = holdService.getHold(name);
        return ResponseEntity
                .ok()
                .contentType(MediaType.valueOf(hold.get().getType()))
                .body(ImageUtility.decompressImage(hold.get().getHoldImage()));
    }

    @GetMapping("/{id}")
    public Hold findHoldById(@PathVariable Long id) throws IOException{
        Optional<Hold> obj = holdService.getHoldId(id);
        //if (obj.isPresent()) {
        //    return obj.get();
        //} else {
        //    return null;
        //}
        //shortened version of the above
        return obj.orElse(null);
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
