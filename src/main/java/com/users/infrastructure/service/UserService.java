package com.users.infrastructure.service;

import com.users.domain.model.User;

import java.util.List;

public interface UserService {

    User addUser(User user);

    User updateUser(User user);

    User findUserById(Integer id);

    List<User> getUserOrderByBirthday();

    List<User> getUserOrderByBmi();

    Boolean existUserByName(String name);

}
