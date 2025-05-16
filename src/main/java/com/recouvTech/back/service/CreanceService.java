package com.recouvTech.back.service;

import com.recouvTech.back.entity.Creance;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CreanceService {
    Creance ajouterCreance(Creance creance);
    Creance modifierCreance(Long id, Creance creance);
    void supprimerCreance(Long id);
    List<Creance> getCreances();
    List<Creance> getCreanceP(Pageable pageable);
    Creance getCreanceById(Long id);
}
