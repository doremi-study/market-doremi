package com.doremi.marketdoremi.domain.member.entity;

import java.io.Serializable;
import java.util.Optional;
import java.util.regex.Pattern;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import com.doremi.marketdoremi.common.utils.StringValidator;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@EqualsAndHashCode
@NoArgsConstructor
@Embeddable
public class MemberId implements Serializable, Validatable{

	private static final String MEMBER_ID_VALIDATION_MESSAGE = "6자 이상의 영문, 혹은 영문과 숫자 조합을 입력해주세요.";

	@Column(name="member_id")
	private String memberId;

	public MemberId(String memberId) {
		checkValidation(memberId);
		this.memberId = memberId;
	}

	@Override
	public void checkValidation(String str) {
		Optional.ofNullable(str)
			.filter(v -> (StringValidator.isAlpha(v)) ||  (!StringValidator.isNumeric(v) && StringValidator.isAlphaNumeric(v)))
			.filter(v -> v.length() >= 6)
			.orElseThrow(() -> new IllegalArgumentException(MEMBER_ID_VALIDATION_MESSAGE));
	}
}
