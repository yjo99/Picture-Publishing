package com.jo.picPublising.persistance.repo;

import com.jo.picPublising.persistance.models.ERoles;
import com.jo.picPublising.persistance.models.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RolesRepo extends JpaRepository<Roles, Long> {

    Optional<Roles> findRolesByRole(ERoles role);
}
