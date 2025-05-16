package com.recouvTech.back.entity;

import com.recouvTech.back.entity.enums.ModePaiement;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Data
@Entity
public class Reglement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private long ReglementId;

    @Column(nullable = false)
    private double montant;

    @Column(nullable = false)
    private LocalDate dateReglement;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ModePaiement modePaiement;

    private String reference;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "creance_id")
    private Creance creance;


    @ManyToOne(fetch = FetchType.EAGER) // Chargement immédiat
    private User agentRecouv;
}
