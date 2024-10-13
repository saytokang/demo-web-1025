package com.example.demoweb.service;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.example.demoweb.dto.UserDto;
import com.example.demoweb.dto.UserResponse;
import com.example.demoweb.entity.UserEntity;
import com.example.demoweb.repository.UserRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@RequiredArgsConstructor
public class UserService {

	private final UserRepository userRepository;

	@Transactional
	public Long save(UserDto json) {
		log.info("service: {}", json);
		// save
		UserEntity entity = json.toEntity();
		UserEntity savedAfter = userRepository.save(entity);
		return savedAfter.getId();
	}

	@Transactional(readOnly = true)
	public UserResponse getUser(Long id) {
		return userRepository.findById(id).map(UserResponse::of).map(rs -> {
			log.info("db user: {}", rs);
			return rs;
		}).orElseThrow(() -> new EntityNotFoundException());
	}

}
