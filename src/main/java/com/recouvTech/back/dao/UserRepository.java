package com.recouvTech.back.dao;

import com.recouvTech.back.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByNom(String nom);

    boolean existsByEmail(String email);
}
