package com.recouvTech.back.service.serviceImpl;

import com.recouvTech.back.dao.ClientRepository;
import com.recouvTech.back.entity.Client;
import com.recouvTech.back.service.ClientService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ClientServiceImpl implements ClientService {

    private ClientRepository clientRep;

    @Autowired
    public ClientServiceImpl(ClientRepository clientRep) {
        this.clientRep = clientRep;
}
    @Override
    public Client ajouterClient(Client client) {
        return clientRep.save(client);
    }

    @Override
    public Client modifierClient(Long id, Client client) {
        Client oldClient = clientRep.findById(client.getClientId()).orElseThrow(() -> new EntityNotFoundException("Client n'existe pas" + client.getClientId()));
        oldClient.setClientId(client.getClientId());
        oldClient.setRaisonSociale(client.getRaisonSociale());
        oldClient.setEmail(client.getEmail());
        oldClient.setTelephone(client.getTelephone());
        oldClient.setRegistreCommerce(client.getRegistreCommerce());
        oldClient.setAdresse(client.getAdresse());
        oldClient.setCreances(client.getCreances());
        return clientRep.save(client);
    }

    @Override
    public void supprimerClient(Long id) {
        clientRep.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Client> getClients() {
        return clientRep.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Client> getClientP(Pageable pageable) {
        return clientRep.findAll(pageable).getContent();
    }

    @Override
    public Client getClientById(Long id) {
        return clientRep.findById(id).orElseThrow(() -> new EntityNotFoundException("Client n'existe pas"+id));
    }
}
