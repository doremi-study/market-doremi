package com.doremi.marketdoremi.domain.member.entity;

import java.io.Serializable;
import java.util.Optional;
import java.util.regex.Pattern;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@EqualsAndHashCode
@NoArgsConstructor
@Embeddable
public class MemberId implements Serializable {

	@Column(name="member_id")
	private String memberId;

	public MemberId(String memberId) {
		checkValidation(memberId);
		this.memberId = memberId;
	}

	private void checkValidation(String memberId) {
		Optional.ofNullable(memberId)
			.filter(v -> isAlpha(v) || isAlphaNumeric(v))
			.filter(v -> v.length() >= 6)
			.orElseThrow(() -> new IllegalArgumentException("6자 이상의 영문, 혹은 영문과 숫자 조합을 입력해주세요."));
	}

	private boolean isAlpha(String str) {
		return Pattern.matches("^[a-zA-Z]*$", str);
	}

	public boolean isAlphaNumeric(String str) {
		return Pattern.matches("[a-zA-Z0-9]*$", str);
	}

}
