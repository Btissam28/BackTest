package com.recouvTech.back.mapper;

import com.recouvTech.back.dto.ClientDTO;
import com.recouvTech.back.dto.CreanceDTO;
import com.recouvTech.back.entity.Client;
import com.recouvTech.back.entity.Creance;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ClientDTOMapper {

    public static ClientDTO toDto(Client client) {
//        List<CreanceDTO> creanceDTOs = client.getCreances() != null ?
//                client.getCreances().stream()
//                        .map(CreanceDTOMapper::toDto)
//                        .toList() :
//                Collections.emptyList();

//        return new ClientDTO(
//                client.getClientId(),
//                client.getRaisonSociale(),
//                client.getEmail(),
//                client.getTelephone(),
//                client.getRegistreCommerce(),
//                client.getAdresse(),
//        );
        ClientDTO clientDTO = new ClientDTO();
        clientDTO.setClientId(client.getClientId());
        clientDTO.setRaisonSociale(client.getRaisonSociale());
        clientDTO.setEmail(client.getEmail());
        clientDTO.setTelephone(client.getTelephone());
        clientDTO.setRegistreCommerce(client.getRegistreCommerce());
        clientDTO.setAdresse(client.getAdresse());

        return clientDTO;
    }

    public static Client toEntity(ClientDTO clientDTO) {
        Client client = new Client();
        client.setClientId(clientDTO.getClientId());
        client.setRaisonSociale(clientDTO.getRaisonSociale());
        client.setEmail(clientDTO.getEmail());
        client.setTelephone(clientDTO.getTelephone());
        client.setRegistreCommerce(clientDTO.getRegistreCommerce());
        client.setAdresse(clientDTO.getAdresse());

        // Note: You might want to handle creances separately
        // as setting them directly might not properly manage the relationship
        return client;
    }

    public Client partialUpdate(ClientDTO clientDTO, Client client) {
        if (clientDTO.getRaisonSociale() != null) {
            client.setRaisonSociale(clientDTO.getRaisonSociale());
        }
        if (clientDTO.getEmail() != null) {
            client.setEmail(clientDTO.getEmail());
        }
        if (clientDTO.getTelephone() != null) {
            client.setTelephone(clientDTO.getTelephone());
        }
        if (clientDTO.getRegistreCommerce() != null) {
            client.setRegistreCommerce(clientDTO.getRegistreCommerce());
        }
        if (clientDTO.getAdresse() != null) {
            client.setAdresse(clientDTO.getAdresse());
        }
        return client;
    }
}