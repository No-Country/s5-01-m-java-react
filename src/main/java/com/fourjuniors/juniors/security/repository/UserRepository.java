package com.fourjuniors.juniors.security.repository;

import com.fourjuniors.juniors.model.entity.Rating;
import com.fourjuniors.juniors.security.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByEmail(String email);

    Optional<User> findByEmail(String email);

    @Query("SELECT u FROM User u INNER JOIN u.projects p WHERE p.id= :id")
    Set<User> findAllByProjectId(Long id);
}
