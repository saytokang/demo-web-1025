package com.example.demoweb.web;

import org.springframework.boot.autoconfigure.cache.CacheProperties.Infinispan;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demoweb.dto.UserDto;
import com.example.demoweb.dto.UserResponse;
import com.example.demoweb.service.UserService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody UserDto json) {
        log.info("{}", json);
        Long id = userService.save(json);
        return ResponseEntity.ok().body(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable long id) {
        log.info("id: {}", id);
        UserResponse rs = userService.getUser(id);
        return ResponseEntity.ok().body(rs);
    }

    @GetMapping("/{id}/profiles/{name}")
    public ResponseEntity<?> getProiflesUserById(@PathVariable String id, @PathVariable String name) {

        return ResponseEntity.ok().build();
    }
}
