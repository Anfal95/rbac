package com.RBAC.RBAC.domain.repositories;


import com.RBAC.RBAC.domain.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findOneById(Long roleId);
}
