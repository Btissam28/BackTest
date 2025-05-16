package com.recouvTech.back.controller;

import com.recouvTech.back.dto.ClientDTO;
import com.recouvTech.back.entity.Client;
import com.recouvTech.back.service.ClientService;
import com.recouvTech.back.mapper.ClientDTOMapper;
import com.recouvTech.back.service.CreanceService;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/clients")
public class ClientRestController {
    private final ClientService clientService;

    public ClientRestController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public ResponseEntity<List<ClientDTO>> getClientsP(Pageable pageable) {
        List<ClientDTO> dtos = clientService.getClientP(pageable).stream().map(ClientDTOMapper::toDto).collect(Collectors.toList());

        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientDTO> getClientById(@PathVariable Long id) {
        Client client = clientService.getClientById(id);
        return ResponseEntity.ok(ClientDTOMapper.toDto(client));
    }

    @PostMapping
    public ResponseEntity<ClientDTO> createClient(@RequestBody ClientDTO clientDTO) {
        Client client = clientService.ajouterClient(ClientDTOMapper.toEntity(clientDTO));
        return new ResponseEntity<>(ClientDTOMapper.toDto(client), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClientDTO> modifierClient(@PathVariable Long id, @RequestBody ClientDTO dto) {
        Client client=clientService.modifierClient(id, ClientDTOMapper.toEntity(dto));
        return new ResponseEntity<>(ClientDTOMapper.toDto(client), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimerClient(@PathVariable Long id) {
        Client client = clientService.getClientById(id);
        clientService.supprimerClient(client.getClientId());
        return ResponseEntity.noContent().build();
    }





}


