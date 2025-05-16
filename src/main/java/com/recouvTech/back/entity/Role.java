package com.recouvTech.back.entity;

import com.recouvTech.back.entity.enums.RoleUser;
import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private RoleUser role;




}
