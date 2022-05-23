package com.example.backendeksamen3semester.service;

import com.example.backendeksamen3semester.Utils.ImageUtility;
import com.example.backendeksamen3semester.model.Galleri;
import com.example.backendeksamen3semester.model.Hold;
import com.example.backendeksamen3semester.repository.GalleriRepository;
import com.example.backendeksamen3semester.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GalleriService {

    public final GalleriRepository galleriRepository;

    @Autowired
    public GalleriService(GalleriRepository galleriRepository) {
        this.galleriRepository = galleriRepository;
    }

    public List<String> getAll() {
        List<Galleri> lst = galleriRepository.findAll();
        List<String> lst2 = new ArrayList<>();
        for (Galleri g : lst){
            lst2.add(g.getName());
        }
        return lst2;
    }

    public Galleri uploadImg(MultipartFile file) throws IOException {
        return galleriRepository.save(Galleri.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .image(ImageUtility.compressImage(file.getBytes())).build());
    }

    public Optional<Galleri> getImg(String name) throws IOException {
        return galleriRepository.findByName(name);
    }

    public void deleteById(Integer id){
        galleriRepository.deleteById(id);
    }

    public Galleri updateGalleri(Galleri galleri){
        return galleriRepository.save(galleri);
    }

}
