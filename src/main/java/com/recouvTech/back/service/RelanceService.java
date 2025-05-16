package com.recouvTech.back.service;

import com.recouvTech.back.entity.Relance;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface RelanceService {

    Relance ajouterRelance(Relance relance);
    Relance modiferRelance(Relance relance);
    void supprimerRelance(Relance relance);
    List<Relance> getRelances();
    List<Relance> getRelanceP(Pageable pageable);
    Relance getRelanceById(Long id);

}
