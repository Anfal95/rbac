package com.RBAC.RBAC.domain.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "permissions")
@NoArgsConstructor
@Getter
@Setter
public class Permission extends BaseEntity{
    private String name;
    private String description;

}
