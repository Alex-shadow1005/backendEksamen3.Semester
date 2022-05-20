package com.example.backendeksamen3semester.service;


import com.example.backendeksamen3semester.model.OmOs;
import com.example.backendeksamen3semester.model.Tipsogtricks;
import com.example.backendeksamen3semester.repository.TipsogtricksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipsogtricksService {

    private final TipsogtricksRepository tipsogtricksRepository;

    @Autowired
    public TipsogtricksService(TipsogtricksRepository tipsogtricksRepository) {
        this.tipsogtricksRepository = tipsogtricksRepository;
    }

    public void createTipsogtricks(Tipsogtricks tipsogtricks){
        tipsogtricksRepository.save(tipsogtricks);
    }

    public List<Tipsogtricks> getTipsogtricks() {
        return tipsogtricksRepository.findAll();
    }

    public void deleteTipsogtricks(Long id){
        tipsogtricksRepository.deleteById(id);
    }

    public Tipsogtricks updateTipsogtricks(Tipsogtricks tipsogtricks){
        return tipsogtricksRepository.save(tipsogtricks);
    }
}


