package com.fourjuniors.juniors.security.repository;

import com.fourjuniors.juniors.security.model.entity.Role;
import com.fourjuniors.juniors.security.model.enums.RoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByName(RoleEnum name);
}
