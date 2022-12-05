package com.fourjuniors.juniors.repository;

import com.fourjuniors.juniors.model.entity.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Long> {

    @Query("SELECT r FROM Rating r WHERE r.project.id = :id")
    Set<Rating> findAllByProjectId(Long id);


    @Query("SELECT r FROM Rating r WHERE r.project.id = :projectId AND r.user.id = :userId")
    Optional<Rating> findByProjectAndUser(Long projectId, Long userId);
}
