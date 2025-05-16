package com.recouvTech.back.entity;

import com.recouvTech.back.entity.enums.StatutRelance;
import com.recouvTech.back.entity.enums.TypeRelance;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Data
@Entity
public class Relance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique= true , nullable = false)
    private long relanceId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "creance_id")
    private Creance creance;

    @ManyToOne
    @JoinColumn(name = "agentRecouv_id")
    private User agentRecouv;

    public LocalDate dateRelance;

    @Enumerated(EnumType.STRING)
    private TypeRelance typeRelance;

    @Enumerated(EnumType.STRING)
    private StatutRelance statutRelance;


    public String commentaire;


}
