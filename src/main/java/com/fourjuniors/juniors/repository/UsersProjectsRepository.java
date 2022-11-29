package com.fourjuniors.juniors.repository;

import com.fourjuniors.juniors.model.entity.UsersProjects;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersProjectsRepository extends JpaRepository<UsersProjects, Long> {
}
