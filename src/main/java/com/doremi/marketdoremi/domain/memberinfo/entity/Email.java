package com.doremi.marketdoremi.domain.memberinfo.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@NoArgsConstructor @AllArgsConstructor @Builder
@Embeddable
public class Email {

	@Column(name = "email", nullable = false)
	private String email;
}
