package com.fourjuniors.juniors.repository;
import com.fourjuniors.juniors.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository <User, Long > {
}
