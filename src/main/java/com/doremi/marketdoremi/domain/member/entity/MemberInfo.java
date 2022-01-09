package com.doremi.marketdoremi.domain.member.entity;

import com.doremi.marketdoremi.web.Sex;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "member_info")
@Builder @AllArgsConstructor @NoArgsConstructor
public class MemberInfo {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idx")
    private Long idx;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @Column(name = "address", nullable = false)
    private String address;

    @Enumerated(EnumType.STRING)
    @Column(name = "sex", nullable = true)
    private Sex sex;

    @Column(name = "birthday", nullable = false)
    private LocalDate birthday;

    public void setMember(Member member) {
        this.member = member;
    }
}
