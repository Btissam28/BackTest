package com.recouvTech.back.controller;


import com.recouvTech.back.dto.CreanceDTO;
import com.recouvTech.back.entity.Client;
import com.recouvTech.back.entity.Creance;
import com.recouvTech.back.mapper.CreanceDTOMapper;
import com.recouvTech.back.service.ClientService;
import com.recouvTech.back.service.CreanceService;
 import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/creances")
public class CreanceRestController {

    private final CreanceService creanceService;
    private final ClientService clientService;

    public CreanceRestController(CreanceService creanceService, ClientService clientService) {
        this.creanceService = creanceService;
        this.clientService = clientService;
    }

    @GetMapping
    public ResponseEntity<List<CreanceDTO>> getCreancesP(Pageable pageable) {
        List<CreanceDTO> dtos = creanceService.getCreanceP(pageable).stream().map(CreanceDTOMapper::toDto).collect(Collectors.toList());

        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

//    @GetMapping
//    public ResponseEntity<List<CreanceDTO>> getCreances() {
//        List<CreanceDTO> dtos = creanceService.getCreances().stream().map(CreanceDTOMapper::toDto).collect(Collectors.toList());
//        return new ResponseEntity<>(dtos, HttpStatus.OK);
//
//    }

    @GetMapping("/{id}")
    public ResponseEntity<CreanceDTO> getCreanceById(@PathVariable Long id) {
        Creance creance = creanceService.getCreanceById(id);
        return ResponseEntity.ok(CreanceDTOMapper.toDto(creance));
    }

    @PostMapping
    public ResponseEntity<CreanceDTO> createCreance(@RequestBody CreanceDTO dto) {
        Client cl = clientService.getClientById(dto.getClientId());
        Creance creance = creanceService.ajouterCreance(CreanceDTOMapper.toEntity(dto, cl));
        return new ResponseEntity<>(CreanceDTOMapper.toDto(creance), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CreanceDTO> modifierCreance(@PathVariable Long id, @RequestBody CreanceDTO dto) {
        Client cl = clientService.getClientById(dto.getClientId());
        Creance creance=creanceService.modifierCreance(id, CreanceDTOMapper.toEntity(dto, cl));
        return new ResponseEntity<>(CreanceDTOMapper.toDto(creance), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimerCreance(@PathVariable Long id) {
        Creance creance = creanceService.getCreanceById(id);
        creanceService.supprimerCreance(creance.getCreanceId());
        return ResponseEntity.noContent().build();
    }
}
