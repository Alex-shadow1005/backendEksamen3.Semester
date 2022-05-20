package com.example.backendeksamen3semester.service;


import com.example.backendeksamen3semester.model.Hold;
import com.example.backendeksamen3semester.model.Nyhed;
import com.example.backendeksamen3semester.model.Tipsogtricks;
import com.example.backendeksamen3semester.repository.NyhedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NyhedService {

    @Autowired
    NyhedRepository nyhedRepository;

    public void createNyhed(Nyhed nyhed){
        nyhedRepository.save(nyhed);
    }

    public List<Nyhed> getNyheder(){
        return nyhedRepository.findAll();
    }

    public Nyhed updateNyhed(Nyhed nyhed){
        return nyhedRepository.save(nyhed);
    }

    public void deleteNyhed(Long id){
        nyhedRepository.deleteById(id);
    }
}
