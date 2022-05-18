package com.example.backendeksamen3semester.repository;

import com.example.backendeksamen3semester.model.Galleri;
import com.example.backendeksamen3semester.model.Hold;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface HoldRepository extends JpaRepository<Hold, Long> {
    Optional<Hold> findByName(String name);
}
