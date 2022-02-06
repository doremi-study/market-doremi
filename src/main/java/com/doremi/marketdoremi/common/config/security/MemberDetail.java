package com.doremi.marketdoremi.common.config.security;

import lombok.Builder;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Getter
public class MemberDetail implements UserDetails {
    private String memberId;
    private String password;
    private Collection<? extends GrantedAuthority> authorities;

    @Builder
    public MemberDetail(String memberId, String password, List<GrantedAuthority> authorities) {
        this.memberId = memberId;
        this.password = password;
        /*List<Role> roles = new ArrayList<>();
        for (GrantedAuthority authority : authorities) {
            Role role = Arrays.stream(Role.values())
                    .filter(code -> code.name().equals(authority))
                    .findFirst()
                    .orElseThrow(() -> new RuntimeException("사용자 권한 : " + authority + "에 해당하는 코드가 없습니다."));
            roles.add(role);
        }
        this.auth = roles;*/
        this.authorities = authorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        /*return Collections.singletonList(new SimpleGrantedAuthority(this.authorities));*/
        return authorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.memberId;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
