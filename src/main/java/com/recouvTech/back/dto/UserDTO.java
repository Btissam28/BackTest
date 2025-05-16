package com.recouvTech.back.dto;

import com.recouvTech.back.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private Long idUser;
    private String nom;
    private String email;
    private Role role;  // Changed to enum type instead of String
}