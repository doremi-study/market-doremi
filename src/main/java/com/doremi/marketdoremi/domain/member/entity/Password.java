package com.doremi.marketdoremi.domain.member.entity;

import java.util.Optional;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import com.doremi.marketdoremi.common.utils.StringValidator;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@EqualsAndHashCode
@Getter
@Embeddable
public class Password implements Validatable{
	@Column(name="password", nullable = false)
	private String password;

	public Password(String password) {
		this.password = password;
	}

	/*
	정규식 (영문(대소문자 구분), 숫자, 특수문자 조합, 9~12자리) */
	@Override
	public void checkValidation(String password) {
		Optional.ofNullable(password)
			.filter(StringValidator::isValidPassword)
			.orElseThrow(() -> new IllegalArgumentException("유효한 비밀번호를 입력해주세요."));
	}
}
