package com.users.infrastructure.service.impl;

import com.users.aspects.Logger;
import com.users.domain.exception.UserNotExistException;
import com.users.domain.model.User;
import com.users.infrastructure.repository.UserJpaRepository;
import com.users.infrastructure.service.UserService;
import com.users.infrastructure.mapper.UserMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserJpaRepository userJpaRepository;

    public UserServiceImpl(UserJpaRepository userJpaRepository) {
        this.userJpaRepository = userJpaRepository;
    }

    @Override
    @Logger
    public User addUser(final User user) {
        return UserMapper.toModel(userJpaRepository.save(UserMapper.toJpa(user)));
    }

    @Override
    @Logger
    public User updateUser(User user) {
        return UserMapper.toModel(userJpaRepository.save(UserMapper.toJpa(user)));
    }

    @Override
    @Logger
    public User findUserById(Integer id) {
        return UserMapper.toModel(userJpaRepository.findById(id).orElseThrow(() -> new UserNotExistException(id)));
    }

    @Override
    public List<User> getUserOrderByBirthday() {
        return UserMapper.toModel(userJpaRepository.findAllByOrderByBirthdate());
    }

    @Override
    public List<User> getUserOrderByBmi() {
        return UserMapper.toModel(userJpaRepository.findAllByOrderByBmi());
    }

    @Override
    @Logger
    public Boolean existUserByName(String name) {
        return userJpaRepository.existsByName(name);
    }
}
