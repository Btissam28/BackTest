package com.recouvTech.back.service.serviceImpl;

import com.recouvTech.back.dao.CreanceRepository;
import com.recouvTech.back.entity.Creance;
import com.recouvTech.back.service.CreanceService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CreanceServiceImpl implements CreanceService {

    private final CreanceRepository creanceRep;

    @Autowired
    public CreanceServiceImpl(CreanceRepository creanceRep) {
        this.creanceRep = creanceRep;
    }


    @Override
    public Creance ajouterCreance(Creance creance) {
        return creanceRep.save(creance);
    }

    @Override
    public Creance modifierCreance(Long id, Creance creance) {
        Creance oldCreance = creanceRep.findById(creance.getCreanceId()).orElseThrow(() ->new EntityNotFoundException("Creance n'existe pas" + creance.getCreanceId()));;
        oldCreance.setCreanceId(creance.getCreanceId());
        oldCreance.setNumFacture(creance.getNumFacture());
        oldCreance.setDateEmission(creance.getDateEmission());
        oldCreance.setEcheance(creance.getEcheance());
        oldCreance.setMontantFacture(creance.getMontantFacture());
        oldCreance.setMontantEncaisse(creance.getMontantEncaisse()/* + reglement.getMontant()*/); /////////////// Dreb tlila 3la hadi mais machi fl update , fl'ajout w list
        oldCreance.setSolde(creance.getSolde());
        oldCreance.setStatut(creance.getStatut());
        oldCreance.setAgentRecouv(creance.getAgentRecouv());
        oldCreance.setClient(creance.getClient());
        oldCreance.setReglements(creance.getReglements());
        oldCreance.setRelances(creance.getRelances());
        return creanceRep.save(creance);
    }

    @Override
    public void supprimerCreance(Long id) {
        creanceRep.deleteById(id);
    }

    @Override
    public List<Creance> getCreances() {
        return creanceRep.findAll();
    }

    @Override
    public List<Creance> getCreanceP(Pageable pageable) {
        return creanceRep.findAll(pageable).getContent();
    }

    @Override
    public Creance getCreanceById(Long id) {
        return creanceRep.findById(id).orElseThrow(() -> new EntityNotFoundException("creance n'existe pas" + id));
    }
}
