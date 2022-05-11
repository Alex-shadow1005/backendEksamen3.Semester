package com.example.backendeksamen3semester.controller;

import com.example.backendeksamen3semester.Utils.ImageUtility;
import com.example.backendeksamen3semester.model.Galleri;
import com.example.backendeksamen3semester.model.Video;
import com.example.backendeksamen3semester.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@RestController
@CrossOrigin
public class VideoController {

    @Autowired
    VideoService videoService;

    @PostMapping("/upload/video")
    public ResponseEntity<ImageUploadResponse> uploadVideo(@RequestParam("video") MultipartFile file)
            throws IOException {

        videoService.uploadVideo(file);
        return ResponseEntity.status(HttpStatus.OK)
                .body(new ImageUploadResponse("Video uploaded successfully: " +
                        file.getOriginalFilename()));
    }

    @GetMapping(path = {"/get/video/{name}"})
    public ResponseEntity<byte[]> getVideo(@PathVariable("name") String name) throws IOException {

        final Optional<Video> dbVideo = videoService.getImg(name);

        return ResponseEntity
                .ok()
                .contentType(MediaType.valueOf(dbVideo.get().getType()))
                .body(ImageUtility.decompressImage(dbVideo.get().getVideo()));
    }

}
