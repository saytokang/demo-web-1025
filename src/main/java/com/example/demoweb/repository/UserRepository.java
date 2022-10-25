package com.example.demoweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demoweb.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    
}
