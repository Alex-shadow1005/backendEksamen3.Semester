package com.example.backendeksamen3semester.service;

import com.example.backendeksamen3semester.Utils.ImageUtility;
import com.example.backendeksamen3semester.model.Hold;
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

    public void createHold(String name, String underOverskrift, String tekst, String pris, int antalKursister, MultipartFile holdImage) throws IOException {

        holdRepository.save(Hold.builder()
                .name(name)
                .underOverskrift(underOverskrift)
                .tekst(tekst)
                .pris(pris)
                .antalKursister(antalKursister)
                .type(holdImage.getContentType())
                .holdImage(ImageUtility.compressImage(holdImage.getBytes())).build());
    }

    public List<Hold> getallHold(){
        return holdRepository.findAll();
    }

    public Hold getHold(Long id){ return holdRepository.findByHoldId(id);}

    public Optional<Hold> getHold(String name) throws IOException {
        return holdRepository.findByName(name);
    }

    public Optional<Hold> getHoldId(Long id) throws IOException {
        return holdRepository.findById(id);
    }

    public void deleteHold(Long id){
        holdRepository.deleteById(id);
    }

    public void updateHold(Long id, String name, String underOverskrift, String tekst, String pris, int antalKursister, MultipartFile holdImage) throws IOException {
        System.out.println("updateHold");
        System.out.println("type: " + holdImage.getContentType());
        holdRepository.updateHoldName(id, name);
        holdRepository.updateHoldUnderOverskrift(id, underOverskrift);
        holdRepository.updateHoldTekst(id, tekst);
        holdRepository.updateHoldPris(id, pris);
        holdRepository.updateHoldAntalKursister(id, antalKursister);
        holdRepository.updateHoldType(id, holdImage.getContentType());
        holdRepository.updateHoldImage(id, ImageUtility.compressImage(holdImage.getBytes()));



        /*
        holdRepository.save(Hold.builder()
                .holdId(id)
                .name(name)
                .underOverskrift(underOverskrift)
                .tekst(tekst)
                .pris(pris)
                .antalKursister(antalKursister)
                .type(holdImage.getContentType())
                .holdImage(ImageUtility.compressImage(holdImage.getBytes()))
                .build());

         */
    }

}
