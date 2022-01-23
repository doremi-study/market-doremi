package com.doremi.marketdoremi.domain.memberinfo.entity;

import com.doremi.marketdoremi.domain.member.entity.Member;
import com.doremi.marketdoremi.domain.member.entity.MemberId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Builder @AllArgsConstructor @NoArgsConstructor
@Table(name = "member_info")
@Entity
public class MemberInfo {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email", nullable = false)
	@Embedded
	private Email email;

	@Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @Column(name = "address", nullable = false)
    private MemberAddress address;

	@Enumerated(EnumType.STRING)
	@Column(name = "gender", nullable = true)
	private Gender gender;

    @Column(name = "birthday", nullable = false)
    private LocalDate birthday;

	@Builder
	public MemberInfo(String memberId, String name, String email, String phoneNumber, String gender, LocalDate birthday, String postNo, String roadAddress, String detailAddress) {
//		this.memberId = new MemberId(memberId);
		this.name = name;
		this.email = new Email(email);
		this.phoneNumber = phoneNumber;
		this.gender = Gender.of(gender);
		this.birthday = birthday;
		this.address = new MemberAddress(postNo, roadAddress, detailAddress);
	}
}
