package com.RBAC.RBAC.domain.entities;

import com.RBAC.RBAC.domain.enums.Roles;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "roles")
@NoArgsConstructor
@Getter
@Setter
public class Role extends BaseEntity{

    @Column(unique = true,nullable = false,name = "name_en")
    @Enumerated(EnumType.STRING)
    private Roles role_en;

    @Column(unique = true,nullable = false,name = "name_ar")
    private String role_ar;

    public Role(Roles role_en, String role_ar) {
        this.role_en = role_en;
        this.role_ar = role_ar;
    }


}
