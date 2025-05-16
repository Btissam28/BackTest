package com.recouvTech.back.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private long clientId;

    @Column(unique = true, nullable = false)
    private String raisonSociale;

    private String email;

    private String telephone;

    private String registreCommerce;

    private String adresse;

    @OneToMany(mappedBy = "client")
    private List<Creance> creances;


    public Client() {
    }

    public Client(long clientId, String raisonSociale, String email, String telephone, String registreCommerce, String adresse) {
        this.clientId = clientId;
        this.raisonSociale = raisonSociale;
        this.email = email;
        this.telephone = telephone;
        this.registreCommerce = registreCommerce;
        this.adresse = adresse;
    }


    public long getClientId() {
        return clientId;
    }

    public void setClientId(long clientId) {
        this.clientId = clientId;
    }

    public String getRaisonSociale() {
        return raisonSociale;
    }

    public void setRaisonSociale(String raisonSociale) {
        this.raisonSociale = raisonSociale;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getRegistreCommerce() {
        return registreCommerce;
    }

    public void setRegistreCommerce(String registreCommerce) {
        this.registreCommerce = registreCommerce;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public List<Creance> getCreances() {
        return creances;
    }

    public void setCreances(List<Creance> creances) {
        this.creances = creances;
    }
}
