package com.doremi.marketdoremi.domain.member.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@EqualsAndHashCode
@Getter @NoArgsConstructor
public class Password {

	@Column(name="password", nullable = false)
	private String password;

	public Password(String password) {
		this.password = password;
	}
}
