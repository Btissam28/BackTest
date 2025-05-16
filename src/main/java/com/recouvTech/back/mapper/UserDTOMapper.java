package com.recouvTech.back.mapper;

import com.recouvTech.back.dto.UserDTO;
import com.recouvTech.back.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserDTOMapper {

    public UserDTO toDto(User user) {
        return new UserDTO(
                user.getIdUser(),
                user.getNom(),
                user.getEmail(),
                user.getRole()
        );
    }

    public User toEntity(UserDTO dto) {
        User user = new User();
        user.setIdUser(dto.getIdUser());
        user.setNom(dto.getNom());
        user.setEmail(dto.getEmail());
        user.setRole(dto.getRole());
        return user;
    }

    public User partialUpdate(UserDTO dto, User user) {
        if (dto.getNom() != null) {
            user.setNom(dto.getNom());
        }

        if (dto.getEmail() != null) {
            user.setEmail(dto.getEmail());
        }

        if (dto.getRole() != null) {
            user.setRole(dto.getRole());
        }
        return user;
    }
}