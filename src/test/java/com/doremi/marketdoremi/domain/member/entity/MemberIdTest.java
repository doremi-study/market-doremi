package com.doremi.marketdoremi.domain.member.entity;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import com.doremi.marketdoremi.common.utils.StringValidator;

class MemberIdTest {

	@ParameterizedTest
	@ValueSource(strings = {"123", "123456", "12abc", "abcde", "ABCabc"})
	@DisplayName("아이디 유효성 체크: 실패케이스")
	void crateMemberFailTest(String input) {
		assertThatThrownBy(() -> new MemberId(input)).isInstanceOf(IllegalArgumentException.class);
	}

	@ParameterizedTest
	@ValueSource(strings = {"123abc", "abcdef", "user123123"})
	@DisplayName("아이디 유효성 체크: 성공 케이스")
	void crateMemberSuccessesTest(String input) {
		assertThat(new MemberId(input)).isEqualTo(new MemberId(input));
	}

	@Test
	void name() {
		//given
		String test = "123abc";
		//when
		boolean alphaNumeric = StringValidator.isAlpha(test);

		assertThat(alphaNumeric).isTrue();

		//then
	}
}