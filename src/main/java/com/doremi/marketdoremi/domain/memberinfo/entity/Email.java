package com.doremi.marketdoremi.domain.memberinfo.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.NoArgsConstructor;

@NoArgsConstructor
@Embeddable
public class Email {

	@Column
	private String email;

	public Email(String email) {
		this.email = email;
	}
}
