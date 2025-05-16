package com.recouvTech.back.dto;

import com.recouvTech.back.entity.enums.ModePaiement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReglementDTO {
    private long reglementId;
    private double montant;
    private LocalDate dateReglement;
    private ModePaiement modePaiement;
    private String reference;

    // Using numFacture for display while keeping ID for reference
    private Long creanceId;
    private String creanceNumFacture;

    // Using agent name for display while keeping ID for reference
    private Long agentRecouvId;
    private String agentRecouvName;
}