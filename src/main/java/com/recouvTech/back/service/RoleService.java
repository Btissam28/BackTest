package com.recouvTech.back.service;

import com.recouvTech.back.entity.Role;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface RoleService {
    Role ajouterRole(Role role);
    Role modifierRole(Role role);
    void supprimerRole(Role role);
    List<Role> getRoles();
    List<Role> getRoleP(Pageable pageable);
    Role getRoleById(Long id);
}
