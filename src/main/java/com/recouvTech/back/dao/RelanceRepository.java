package com.recouvTech.back.dao;

import com.recouvTech.back.entity.Relance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RelanceRepository extends JpaRepository<Relance, Long> {}
