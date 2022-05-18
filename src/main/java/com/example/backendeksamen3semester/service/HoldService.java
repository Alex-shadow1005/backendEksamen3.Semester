package com.example.backendeksamen3semester.service;

import com.example.backendeksamen3semester.model.Hold;
import com.example.backendeksamen3semester.repository.HoldRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HoldService {

    private final HoldRepository holdRepository;

    @Autowired
    public HoldService(HoldRepository holdRepository){
        this.holdRepository = holdRepository;
    }

    public void createHold(Hold hold){
        holdRepository.save(hold);
    }

    public List<Hold> getHold(){
        return holdRepository.findAll();
    }

    public void deleteHold(Long id){
        holdRepository.deleteById(id);
    }

    public Hold updateHold(Hold hold){
        return holdRepository.save(hold);
    }

}
