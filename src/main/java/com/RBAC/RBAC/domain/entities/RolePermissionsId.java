package com.RBAC.RBAC.domain.entities;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Data
@EqualsAndHashCode
@Embeddable
@Setter
@Getter
public class RolePermissionsId implements Serializable {

    @Column(name = "permission_id")
    private Long permissionId;

    @Column(name = "role_id")
    private Long roleId;

    public RolePermissionsId()
    {
    }

    public RolePermissionsId(Long userId, Long roleId)
    {
        this.permissionId = userId;
        this.roleId = roleId;
    }

    @Override
    public boolean equals(Object pO)
    {
        if (this == pO)
        {
            return true;
        }
        if (pO == null || getClass() != pO.getClass())
        {
            return false;
        }

        RolePermissionsId abId = (RolePermissionsId) pO;

        if (!Objects.equals(permissionId, abId.permissionId))
        {
            return false;
        }

        return Objects.equals(roleId, abId.roleId);

    }

    @Override
    public int hashCode()
    {
        int result = permissionId != null ? permissionId.hashCode() : 0;
        result = 31 * result + (roleId != null ? roleId.hashCode() : 0);
        return result;
    }

}
