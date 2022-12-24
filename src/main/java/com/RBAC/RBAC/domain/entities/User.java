package com.RBAC.RBAC.domain.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "users")
@Setter
@Getter
public class User extends BaseEntity{

    @Column(unique = true)
    @Email
    private String email;

    @Column(name = "name",nullable = false)
    @NotNull
    private String name;

    @NotNull
    private String phone_number;

}
