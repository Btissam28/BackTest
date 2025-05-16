package com.recouvTech.back.dto;

import com.recouvTech.back.entity.enums.StatutCreance;
import lombok.Data;

import java.time.LocalDate;

@Data
public class CreanceDTO {

    private long creanceId;
    private String numFacture;
    private LocalDate dateEmission;
    private LocalDate echeance;
    private double montantFacture;
    private double montantEncaisse;
    private double solde;
    private String statut;
    private Long agentRecouvId;
    private Long clientId;

    public CreanceDTO() {}

    public CreanceDTO(long creanceId, String numFacture, LocalDate dateEmission, LocalDate echeance, double montantFacture, double montantEncaisse, double solde, StatutCreance statut, Long agentRecouvId, Long clientId) {
        this.creanceId = creanceId;
        this.numFacture = numFacture;
        this.dateEmission = dateEmission;
        this.echeance = echeance;
        this.montantFacture = montantFacture;
        this.montantEncaisse = montantEncaisse;
        this.solde = solde;
        this.statut = String.valueOf(statut);
        this.agentRecouvId = agentRecouvId;
        this.clientId = clientId;
    }

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

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public void setAgentRecouvId(Long agentRecouvId) {
        this.agentRecouvId = agentRecouvId;
    }

    public Long getClientId() {
        return this.clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }
}
