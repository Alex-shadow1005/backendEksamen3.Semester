package com.example.backendeksamen3semester.service;

import com.example.backendeksamen3semester.Utils.ImageUtility;
import com.example.backendeksamen3semester.model.Galleri;
import com.example.backendeksamen3semester.model.Video;
import com.example.backendeksamen3semester.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
public class VideoService {

    public final VideoRepository videoRepository;

    @Autowired
    public VideoService(VideoRepository videoRepository){
        this.videoRepository = videoRepository;
    }

    public Video uploadVideo(MultipartFile file) throws IOException {
        return videoRepository.save(Video.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .video(ImageUtility.compressImage(file.getBytes())).build());
    }

    public Optional<Video> getImg(String name) throws IOException {
        return videoRepository.findByName(name);
    }
}
