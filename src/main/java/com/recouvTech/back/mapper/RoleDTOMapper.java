package com.recouvTech.back.mapper;

import com.recouvTech.back.dto.RoleDTO;
import com.recouvTech.back.entity.Role;
import org.springframework.stereotype.Component;

@Component
public class RoleDTOMapper {

    public RoleDTO toDto(Role role) {
        if (role == null) {
            return null;
        }

        return new RoleDTO(
                role.getId(),
                role.getRole()
        );
    }

    public Role toEntity(RoleDTO dto) {
        if (dto == null) {
            return null;
        }

        Role role = new Role();
        role.setId(dto.getId());
        role.setRole(dto.getRole());
        return role;
    }

    public void updateEntity(RoleDTO dto, Role entity) {
        if (dto == null || entity == null) {
            return;
        }

        if (dto.getRole() != null) {
            entity.setRole(dto.getRole());
        }
    }
}