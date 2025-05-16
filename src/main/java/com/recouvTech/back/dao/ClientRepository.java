package com.recouvTech.back.dao;

import com.recouvTech.back.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    Client findByRaisonSociale(String clientName);
}
