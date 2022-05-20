package com.example.backendeksamen3semester.service;

import com.example.backendeksamen3semester.model.OmOs;
import com.example.backendeksamen3semester.repository.OmOsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OmOsService {

    private final OmOsRepository omOsRepository;

    @Autowired
    public OmOsService(OmOsRepository omOsRepository) {
        this.omOsRepository = omOsRepository;
    }

    public void createOmOs(OmOs omOs){
        omOsRepository.save(omOs);
    }

    public List<OmOs> getOmOs(){
        return omOsRepository.findAll();
    }

    public void deleteOmOs(Long id){
        omOsRepository.deleteById(id);
    }

    public OmOs updateOmOs(OmOs omOs){
        return omOsRepository.save(omOs);
    }
}
