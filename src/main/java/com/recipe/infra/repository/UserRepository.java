package com.recipe.infra.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.recipe.infra.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

}
