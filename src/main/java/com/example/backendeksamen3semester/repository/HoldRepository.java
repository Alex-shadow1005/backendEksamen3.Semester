package com.example.backendeksamen3semester.repository;

import com.example.backendeksamen3semester.model.Galleri;
import com.example.backendeksamen3semester.model.Hold;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HoldRepository extends JpaRepository<Hold, Long> {
}
