package com.redis.service;

import com.redis.model.User;

import java.util.List;

public interface UserSevice {
    boolean saveUser(User user);

    List<User> fetchAllUsers();

    User fetchUserById(Long id);

    boolean deleteUser(Long id);
}
