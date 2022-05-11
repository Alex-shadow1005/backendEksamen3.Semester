package com.example.backendeksamen3semester.repository;

import com.example.backendeksamen3semester.model.Video;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VideoRepository extends JpaRepository<Video, Integer> {
    Optional<Video> findByName(String name);
}
