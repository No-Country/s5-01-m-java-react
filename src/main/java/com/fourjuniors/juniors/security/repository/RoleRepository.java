package com.fourjuniors.juniors.security.repository;

import com.tutorial.crudmongoback.security.entity.Role;
import com.tutorial.crudmongoback.security.enums.RoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByName(RoleEnum name);
}
