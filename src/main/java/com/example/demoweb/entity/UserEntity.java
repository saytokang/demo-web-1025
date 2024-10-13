package com.example.demoweb.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "t_user")
@NoArgsConstructor
@Getter
public class UserEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "name")
	private String name;

	private String email;

	@Column(name = "nick_name")
	private String nickName;

	@Builder
	public UserEntity(String name, String email, String nickName) {
		this.name = name;
		this.email = email;
		this.nickName = nickName;
	}

}
