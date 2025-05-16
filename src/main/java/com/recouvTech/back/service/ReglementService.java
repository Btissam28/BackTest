package com.recouvTech.back.service;

import com.recouvTech.back.entity.Reglement;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ReglementService {
    Reglement ajouterReglement(Reglement reglement);
    Reglement modifierReglement(Reglement reglement);
    void supprimerReglement(Reglement reglement);
    List<Reglement> getReglements();
    List<Reglement> getReglementP(Pageable pageable);
    Reglement getReglementById(Long id);
}
