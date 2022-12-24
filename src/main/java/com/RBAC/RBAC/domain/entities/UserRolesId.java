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
public class UserRolesId implements Serializable {

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "role_id")
    private Long roleId;

    public UserRolesId()
    {
    }

    public UserRolesId(Long userId, Long roleId)
    {
        this.userId = userId;
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

        UserRolesId abId = (UserRolesId) pO;

        if (!Objects.equals(userId, abId.userId))
        {
            return false;
        }

        return Objects.equals(roleId, abId.roleId);

    }

    @Override
    public int hashCode()
    {
        int result = userId != null ? userId.hashCode() : 0;
        result = 31 * result + (roleId != null ? roleId.hashCode() : 0);
        return result;
    }

}
