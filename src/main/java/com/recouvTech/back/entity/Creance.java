package com.recouvTech.back.entity;

import com.recouvTech.back.entity.enums.StatutCreance;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
public class Creance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private long creanceId;

    @Column(unique = true, nullable = false)
    private String numFacture;

    @Column(nullable = false)
    private LocalDate dateEmission;

    @Column(nullable = false)
    private LocalDate echeance;

    @Column(nullable = false)
    private double montantFacture;

    private double montantEncaisse;

    private double solde;

    @Column(nullable = false)
    private StatutCreance statut;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "agentRecouv_id")
    private User agentRecouv;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id")
    private Client client;

    @OneToMany(mappedBy = "creance")
    private List<Reglement> reglements;

    @OneToMany(mappedBy = "creance")
    private List<Relance> relances;


    public long getCreanceId() {
        return creanceId;
    }

    public void setCreanceId(long creanceId) {
        this.creanceId = creanceId;
    }

    public String getNumFacture() {
        return numFacture;
    }

    public void setNumFacture(String numFacture) {
        this.numFacture = numFacture;
    }

    public LocalDate getDateEmission() {
        return dateEmission;
    }

    public void setDateEmission(LocalDate dateEmission) {
        this.dateEmission = dateEmission;
    }

    public LocalDate getEcheance() {
        return echeance;
    }

    public void setEcheance(LocalDate echeance) {
        this.echeance = echeance;
    }

    public double getMontantFacture() {
        return montantFacture;
    }

    public void setMontantFacture(double montantFacture) {
        this.montantFacture = montantFacture;
    }

    public double getMontantEncaisse() {
        return montantEncaisse;
    }

    public void setMontantEncaisse(double montantEncaisse) {
        this.montantEncaisse = montantEncaisse;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    public StatutCreance getStatut() {
        return statut;
    }

    public void setStatut(StatutCreance statut) {
        this.statut = statut;
    }

    public User getAgentRecouv() {
        return agentRecouv;
    }

    public void setAgentRecouv(User agentRecouv) {
        this.agentRecouv = agentRecouv;
    }

    public Client getClient() {
        return client;
    }



    public void setClient(Client client) {
        this.client = client;
    }
}
