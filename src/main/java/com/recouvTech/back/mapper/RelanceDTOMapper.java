package com.recouvTech.back.mapper;

import com.recouvTech.back.dto.RelanceDTO;
import com.recouvTech.back.entity.Relance;
import org.springframework.stereotype.Component;

@Component
public class RelanceDTOMapper {

    public RelanceDTO toDto(Relance relance) {
        if (relance == null) {
            return null;
        }

        return new RelanceDTO(
                relance.getRelanceId(),
                relance.getCreance() != null ? relance.getCreance().getCreanceId() : null,
                relance.getCreance() != null ? relance.getCreance().getNumFacture() : null,
                relance.getAgentRecouv() != null ? relance.getAgentRecouv().getIdUser() : null,
                relance.getAgentRecouv() != null ? relance.getAgentRecouv().getNom() : null,
                relance.getDateRelance(),
                relance.getTypeRelance(),
                relance.getStatutRelance(),
                relance.getCommentaire()
        );
    }

    public Relance toEntity(RelanceDTO dto) {
        if (dto == null) {
            return null;
        }

        Relance relance = new Relance();
        relance.setRelanceId(dto.getRelanceId());
        relance.setDateRelance(dto.getDateRelance());
        relance.setTypeRelance(dto.getTypeRelance());
        relance.setStatutRelance(dto.getStatutRelance());
        relance.setCommentaire(dto.getCommentaire());

        // Relationships handled by service layer
        return relance;
    }

    public void updateEntity(RelanceDTO dto, Relance entity) {
        if (dto == null || entity == null) {
            return;
        }

        if (dto.getDateRelance() != null) {
            entity.setDateRelance(dto.getDateRelance());
        }
        if (dto.getTypeRelance() != null) {
            entity.setTypeRelance(dto.getTypeRelance());
        }
        if (dto.getStatutRelance() != null) {
            entity.setStatutRelance(dto.getStatutRelance());
        }
        if (dto.getCommentaire() != null) {
            entity.setCommentaire(dto.getCommentaire());
        }
    }
}