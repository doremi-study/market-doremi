package com.doremi.marketdoremi.domain.member.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@EqualsAndHashCode
@Getter
@Embeddable
public class Password {
	@Column(name="password")
	private String password;

	public Password(String password) {
		this.password = password;
	}
}
