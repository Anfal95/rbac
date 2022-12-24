package com.RBAC.RBAC.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "users_roles")
@Getter
@Setter
public class UsersRoles {

    @EmbeddedId
    private UserRolesId id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @MapsId("user_id")
    @JsonIgnore
    private User user;


    @ManyToOne
    @MapsId("role_id")
    private Role role;

    @CreationTimestamp
    private Timestamp createdAt;

    @UpdateTimestamp
    private Timestamp updatedAt;

    public UsersRoles(Long userId, Long roleId) {
        this.id = new UserRolesId(userId,roleId);
    }

    public UsersRoles() {
    }
}
