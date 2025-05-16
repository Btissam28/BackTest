package com.recouvTech.back.mapper;

import com.recouvTech.back.dto.ReglementDTO;
import com.recouvTech.back.entity.Reglement;
import org.springframework.stereotype.Component;

@Component
public class ReglementDTOMapper {

    public ReglementDTO toDto(Reglement reglement) {
        return new ReglementDTO(
                reglement.getReglementId(),
                reglement.getMontant(),
                reglement.getDateReglement(),
                reglement.getModePaiement(),
                reglement.getReference(),
                // IDs for reference
                reglement.getCreance() != null ? reglement.getCreance().getCreanceId() : null,
                // Display fields
                reglement.getCreance() != null ? reglement.getCreance().getNumFacture() : null,
                reglement.getAgentRecouv() != null ?
                        reglement.getAgentRecouv().getIdUser() : null,
                reglement.getAgentRecouv() != null ?
                        reglement.getAgentRecouv().getNom() : null
        );
    }

    public Reglement toEntity(ReglementDTO dto) {
        Reglement reglement = new Reglement();
        reglement.setReglementId(dto.getReglementId());
        reglement.setMontant(dto.getMontant());
        reglement.setDateReglement(dto.getDateReglement());
        reglement.setModePaiement(dto.getModePaiement());
        reglement.setReference(dto.getReference());

        // Note: Relationships are handled by service layer using the IDs
        return reglement;
    }

    public Reglement partialUpdate(ReglementDTO dto, Reglement reglement) {
        if (dto.getMontant() != 0) {
            reglement.setMontant(dto.getMontant());
        }
        if (dto.getDateReglement() != null) {
            reglement.setDateReglement(dto.getDateReglement());
        }
        if (dto.getModePaiement() != null) {
            reglement.setModePaiement(dto.getModePaiement());
        }
        if (dto.getReference() != null) {
            reglement.setReference(dto.getReference());
        }
        return reglement;
    }
}