package com.recouvTech.back.service;

import com.recouvTech.back.entity.User;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {
    User ajouterUser(User user);
    User modifierUser(User user);
    void supprimerUser(User user);
    List<User> getUsers();
    List<User> getUserP(Pageable pageable);
    User getUserById(Long id);
}
