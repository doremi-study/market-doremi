package com.doremi.marketdoremi.domain.memberinfo.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.doremi.marketdoremi.domain.member.entity.Member;
import com.doremi.marketdoremi.domain.member.entity.MemberId;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import com.doremi.marketdoremi.domain.member.entity.Member;
import com.doremi.marketdoremi.domain.member.entity.MemberId;
import com.doremi.marketdoremi.web.Sex;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Builder @AllArgsConstructor @NoArgsConstructor
@EqualsAndHashCode
@Table(name = "member_info")
@Entity
public class MemberInfo {
    /*
    * 필수적 비식별 관계 : 연관관계를 필수적으로 맺어 FK에 NULL을 허용하지 않는다.
    * 선택적 비식별 관계 : 연관관계를 선택적으로 맺어 FK에 NULL을 허용한다.
    * */

    /*
    * 1:1 식별관계 상위 테이블의 PK를 받아 하위 테이블의 단일 PK + FK로 사용하는 관계
    * - 복합키가 아니면 식별자 클래스를 생성할 필요가 없다.
    * - 식별자 매핑인 @Id와 연관관계 매핑인 @MapsId를 같이 사용한다.
    * - PK가 복합키가 아니면 @MapsId의 속성 값은 비워 둔다.
    *
    * @EmbeddedId : 식별자 매핑
    * @MapsId : 연관관계 매핑 (외래키와 매핑한 연관관계를 기본키에도 매핑하겠다는 의미)
    * 둘을 같이 사용한다.
    * 별도의 @Embeddable 식별자 클래스를 생성한다.
    * @MapsId의 속성값은 PK의 필드명이다.
    * */

    @EmbeddedId//식별자 매핑
    private MemberInfoId id;

    @MapsId("memberId")//@MapsId의 속성 값은 PK의 필드명
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email", nullable = false)
	@Embedded
	private Email email;


	@Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @Column(name = "address", nullable = false)
    private String address;

	@Enumerated(EnumType.STRING)
	@Column(name = "gender", nullable = true)
	private Gender gender;

    @Column(name = "birthday", nullable = false)
    private LocalDate birthday;

	@Column(name = "address", nullable = false)
	private MemberAddress address;

	@Builder
	public MemberInfo(String memberId, String name, String email, String phoneNumber, String gender, LocalDate birthday, String postNo, String roadAddress, String detailAddress) {
		this.memberId = new MemberId(memberId);
		this.name = name;
		this.email = new Email(email);
		this.phoneNumber = phoneNumber;
		this.gender = Gender.of(gender);
		this.birthday = birthday;
		this.address = new MemberAddress(postNo, roadAddress, detailAddress);
	}

    @EqualsAndHashCode
    @Embeddable// implements Serializable 해야한다.
    private class MemberInfoId implements Serializable {

        private MemberId memberId;//@MapsId로 매핑
    }
}
