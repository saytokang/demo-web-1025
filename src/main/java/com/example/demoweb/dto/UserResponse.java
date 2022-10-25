package com.example.demoweb.dto;

import javax.annotation.Generated;

import com.example.demoweb.entity.UserEntity;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
@Builder
public class UserResponse {
    private long id;
    private String name;
    private String email;
    private String nickName;

    public static UserResponse of(UserEntity a) {
        return UserResponse.builder()
        .id(a.getId())
        .name(a.getName())
        .email(a.getEmail())
        .nickName(a.getNickName())
        .build();
    }
}
