package com.example.demoweb.dto;

import com.example.demoweb.entity.UserEntity;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class UserDto {

	private String name;

	private String email;

	@JsonProperty("nick_name")
	private String nickName;

	public UserEntity toEntity() {
		return UserEntity.builder().name(this.name).email(this.email).nickName(this.nickName).build();
	}

}
