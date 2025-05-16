package com.recouvTech.back.dto;

import com.recouvTech.back.entity.enums.StatutRelance;
import com.recouvTech.back.entity.enums.TypeRelance;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RelanceDTO {
    private Long relanceId;
    private Long creanceId;          // Changed from String to ID
    private String creanceNumFacture; // Additional reference info
    private Long agentRecouvId;      // Changed from String to ID
    private String agentRecouvName;  // Additional display info
    private LocalDate dateRelance;
    private TypeRelance typeRelance;
    private StatutRelance statutRelance;
    private String commentaire;
}