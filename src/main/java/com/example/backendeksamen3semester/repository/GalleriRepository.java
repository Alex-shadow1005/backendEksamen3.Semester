package com.example.backendeksamen3semester.repository;


import com.example.backendeksamen3semester.model.Galleri;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GalleriRepository extends JpaRepository<Galleri, Integer> {
    Optional<Galleri> findByName(String name);
}
