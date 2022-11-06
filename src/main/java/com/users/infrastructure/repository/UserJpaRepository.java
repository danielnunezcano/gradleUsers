package com.users.infrastructure.repository;

import com.users.infrastructure.repository.jpa.UserJpa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserJpaRepository extends JpaRepository<UserJpa, Integer> {

    Boolean existsByName(String name);

    List<UserJpa> findAllByOrderByBirthdate();

    List<UserJpa> findAllByOrderByBmi();

}
