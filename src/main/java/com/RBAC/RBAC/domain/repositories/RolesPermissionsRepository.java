package com.RBAC.RBAC.domain.repositories;

import com.RBAC.RBAC.domain.entities.RolesPermissions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolesPermissionsRepository extends JpaRepository<RolesPermissions,Long> {
}
