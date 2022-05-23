package com.example.backendeksamen3semester.repository;


import com.example.backendeksamen3semester.model.Hold;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

public interface HoldRepository extends JpaRepository<Hold, Long> {
    Optional<Hold> findByName(String name);


    @Modifying
    @Transactional
    @Query("UPDATE Hold h set h.name=:holdName where h.holdId=:id")
    void updateHoldName(@Param("id") Long id, @Param("holdName") String holdName);

    @Modifying
    @Transactional
    @Query("UPDATE Hold h set h.underOverskrift=:holdUnderOverskrift where h.holdId=:id")
    void updateHoldUnderOverskrift(@Param("id") Long id, @Param("holdUnderOverskrift") String holdUnderOverskrift);

    @Modifying
    @Transactional
    @Query("UPDATE Hold h set h.tekst=:holdTekst where h.holdId=:id")
    void updateHoldTekst(@Param("id") Long id, @Param("holdTekst") String holdTekst);

    @Modifying
    @Transactional
    @Query("UPDATE Hold h set h.pris=:holdPris where h.holdId=:id")
    void updateHoldPris(@Param("id") Long id, @Param("holdPris") String holdPris);

    @Modifying
    @Transactional
    @Query("UPDATE Hold h set h.antalKursister=:holdAntalKursister where h.holdId=:id")
    void updateHoldAntalKursister(@Param("id") Long id, @Param("holdAntalKursister") int holdAntalKursister);

    @Modifying
    @Transactional
    @Query("UPDATE Hold h set h.holdImage=:holdImg where h.holdId=:id")
    void updateHoldImage(@Param("id") Long id, @Param("holdImg") byte[] holdImg);

    @Modifying
    @Transactional
    @Query("UPDATE Hold h set h.type=:holdType where h.holdId=:id")
    void updateHoldType(@Param("id") Long id, @Param("holdType") String holdType);
}
