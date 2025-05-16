package com.recouvTech.back.mapper;

import com.recouvTech.back.dto.CreanceDTO;
import com.recouvTech.back.entity.Client;
import com.recouvTech.back.entity.Creance;
import com.recouvTech.back.entity.enums.StatutCreance;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.String.valueOf;

@Component
public class CreanceDTOMapper {

    public static CreanceDTO toDto(Creance creance) {
        if (creance == null) {
            return null;
        }

        return new CreanceDTO(
                creance.getCreanceId(),
                creance.getNumFacture(),
                creance.getDateEmission(),
                creance.getEcheance(),
                creance.getMontantFacture(),
                creance.getMontantEncaisse(),
                creance.getSolde(),
                creance.getStatut(),
                creance.getAgentRecouv() != null ? creance.getAgentRecouv().getIdUser() : null,
                creance.getClient() != null ? creance.getClient().getClientId() : null
//                creance.getReglements() != null ? creance.getReglements().getIdReglement() : null,
//                creance.getRelances() != null && !creance.getRelances().isEmpty() ?
//                        creance.getRelances().get(0).getRelanceId() : null
        );
    }

    public static Creance toEntity(CreanceDTO creanceDTO , Client client) {
        Creance creance = new Creance();
        creance.setCreanceId(creanceDTO.getCreanceId());
        creance.setNumFacture(creanceDTO.getNumFacture());
        creance.setDateEmission(creanceDTO.getDateEmission());
        creance.setEcheance(creanceDTO.getEcheance());
        creance.setMontantFacture(creanceDTO.getMontantFacture());
        creance.setMontantEncaisse(creanceDTO.getMontantEncaisse());
        creance.setSolde(creanceDTO.getSolde());
        creance.setStatut(StatutCreance.valueOf(creanceDTO.getStatut()));
        creance.setClient(client);

        // Note: Relationships should be handled in service layer
        return creance;
    }

    public Creance partialUpdate(CreanceDTO dto, Creance entity) {
        if (dto.getNumFacture() != null) {
            entity.setNumFacture(dto.getNumFacture());
        }
        if (dto.getDateEmission() != null) {
            entity.setDateEmission(dto.getDateEmission());
        }
        if (dto.getEcheance() != null) {
            entity.setEcheance(dto.getEcheance());
        }
        if (dto.getMontantFacture() != 0) {
            entity.setMontantFacture(dto.getMontantFacture());
        }
        if (dto.getMontantEncaisse() != 0) {
            entity.setMontantEncaisse(dto.getMontantEncaisse());
        }
        if (dto.getSolde() != 0) {
            entity.setSolde(dto.getSolde());
        }
        if (dto.getStatut() != null) {
            entity.setStatut(StatutCreance.valueOf(dto.getStatut()));
        }
        return entity;
    }
}