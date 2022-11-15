package com.fourjuniors.juniors.service;

import com.fourjuniors.juniors.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    public List<User> list();

    public Optional<User> getOne(Long id);

    public void save(User usuario);

    public void delete(Long id);

    public boolean existById(Long id);

}
