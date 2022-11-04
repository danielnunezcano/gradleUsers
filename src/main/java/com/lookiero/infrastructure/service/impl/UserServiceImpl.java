package com.lookiero.infrastructure.service.impl;

import com.lookiero.aspects.Logger;
import com.lookiero.domain.exception.UserNotExistException;
import com.lookiero.domain.model.User;
import com.lookiero.infrastructure.repository.UserJpaRepository;
import com.lookiero.infrastructure.service.UserService;
import com.lookiero.infrastructure.mapper.UserMapper;
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
