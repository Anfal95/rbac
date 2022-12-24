package com.RBAC.RBAC.domain.repositories;

import com.RBAC.RBAC.domain.entities.Role;
import com.RBAC.RBAC.domain.entities.UsersRoles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRolesRepository extends JpaRepository<UsersRoles, Long> {
}
