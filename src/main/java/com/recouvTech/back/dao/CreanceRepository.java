package com.recouvTech.back.dao;

import com.recouvTech.back.entity.Creance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreanceRepository extends JpaRepository<Creance, Long> {
    Creance findByNumFacture(String numFacture);
}
