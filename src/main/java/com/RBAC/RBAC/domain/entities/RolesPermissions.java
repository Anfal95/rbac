package com.RBAC.RBAC.domain.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "role_permissions")
@Getter
@Setter
public class RolesPermissions {

    @EmbeddedId
    private RolePermissionsId id;

    @ManyToOne
    @JoinColumn(name = "permission_id")
    @MapsId("permission_id")
    @JsonIgnore
    private Permission permission;


    @ManyToOne
    @MapsId("role_id")
    private Role role;

    @CreationTimestamp
    private Timestamp createdAt;

    @UpdateTimestamp
    private Timestamp updatedAt;

    public RolesPermissions(Long permissionId, Long roleId) {
        this.id = new RolePermissionsId(permissionId,roleId);
    }

    public RolesPermissions() {
    }

}
