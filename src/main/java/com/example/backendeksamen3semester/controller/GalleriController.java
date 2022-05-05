package com.example.backendeksamen3semester.controller;

import com.example.backendeksamen3semester.Utils.ImageUtility;
import com.example.backendeksamen3semester.model.Galleri;
import com.example.backendeksamen3semester.repository.GalleriRepository;
import com.example.backendeksamen3semester.service.GalleriService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class GalleriController {

    @Autowired
    GalleriRepository galleriRepository;

    @Autowired
    GalleriService galleriService;
    // Metode fra https://www.techgeeknext.com/spring-boot/spring-boot-upload-image
    @PostMapping("/upload/image")
    public ResponseEntity<ImageUploadResponse> uploadImage(@RequestParam("image") MultipartFile file)
            throws IOException {

        galleriService.uploadImg(file);
        return ResponseEntity.status(HttpStatus.OK)
                .body(new ImageUploadResponse("Image uploaded successfully: " +
                        file.getOriginalFilename()));
    }

    @GetMapping("/galleri")
    public List<String> getAllImageNames() {
        return galleriService.getAll();

    }

    // Metode fra https://www.techgeeknext.com/spring-boot/spring-boot-upload-image
    @GetMapping(path = {"/get/image/{name}"})
    public ResponseEntity<byte[]> getImage(@PathVariable("name") String name) throws IOException {

        final Optional<Galleri> dbImage = galleriService.getImg(name);

        return ResponseEntity
                .ok()
                .contentType(MediaType.valueOf(dbImage.get().getType()))
                .body(ImageUtility.decompressImage(dbImage.get().getImage()));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteImage(@PathVariable Integer id) {
        try {
            galleriRepository.deleteById(id);
            return new ResponseEntity<>("Slettet id=" + id, HttpStatus.OK);
        } catch (Exception err){
            return new ResponseEntity<>("Jeg kunnne ikke slet id=" + id, HttpStatus.NOT_FOUND);
        }

    }

}

