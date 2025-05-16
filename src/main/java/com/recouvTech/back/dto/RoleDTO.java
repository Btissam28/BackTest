package com.recouvTech.back.dto;

import com.recouvTech.back.entity.enums.RoleUser;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoleDTO {

    private long id;
    private RoleUser role;

}
