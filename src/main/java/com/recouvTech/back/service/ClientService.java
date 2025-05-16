package com.recouvTech.back.service;

import com.recouvTech.back.entity.Client;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ClientService {
    Client ajouterClient(Client client);
    Client modifierClient(Long id, Client client);
    void supprimerClient(Long id);
    List<Client> getClients();
    List<Client> getClientP(Pageable pageable);
    Client getClientById(Long id);
}
