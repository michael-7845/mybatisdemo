package com.elements.user.mapperTry;

import com.elements.user.model.User;

import java.util.List;

/**
 * Not Run Okey!!!!!!!!
 */
public interface UserMapper {
    public List<User> getAllUser();

    public User getUserById(String userId);

    public int insert(User user);

    public int update(User user);

    public int delete(User user);
}

