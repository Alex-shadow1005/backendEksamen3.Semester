package com.example.backendeksamen3semester.service;

import com.example.backendeksamen3semester.Utils.ImageUtility;
import com.example.backendeksamen3semester.model.Hold;
import com.example.backendeksamen3semester.model.OmOs;
import com.example.backendeksamen3semester.repository.HoldRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class HoldService {

    private final HoldRepository holdRepository;

    @Autowired
    public HoldService(HoldRepository holdRepository){
        this.holdRepository = holdRepository;
    }


    public void create(Hold hold){
        holdRepository.save(hold);
    }
    /*public void createHold(Hold hold) throws IOException {

        holdRepository.save(Hold.builder()
                .name(hold.getName())
                .underOverskrift(hold.getUnderOverskrift())
                .tekst(hold.getTekst())
                .pris(hold.getPris())
                .antalKursister(hold.getAntalKursister())
                .type(holdImage.getContentType())
                .holdImage(ImageUtility.compressImage(holdImage.getBytes())).build());
    }

     */

    public List<Hold> getallHold(){
        return holdRepository.findAll();
    }

    public Optional<Hold> getHold(String name) throws IOException {
        return holdRepository.findByName(name);
    }

    public Optional<Hold> getHoldId(Long id) throws IOException {
        return holdRepository.findById(id);
    }

    public void deleteHold(Long id){
        holdRepository.deleteById(id);
    }

    public Hold updateHold(Hold hold){
        return holdRepository.save(hold);
    }

}
