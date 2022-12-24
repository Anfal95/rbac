package com.RBAC.RBAC.domain.repositories;


import com.RBAC.RBAC.domain.entities.Permission;
import com.RBAC.RBAC.domain.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissionRepository extends JpaRepository<Permission,Long> {

    Permission findOneById(Long permissionId);
}
