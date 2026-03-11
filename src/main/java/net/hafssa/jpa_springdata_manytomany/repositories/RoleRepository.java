package net.hafssa.jpa_springdata_manytomany.repositories;

import net.hafssa.jpa_springdata_manytomany.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long> {
    Role findByRoleName(String roleName);
}
