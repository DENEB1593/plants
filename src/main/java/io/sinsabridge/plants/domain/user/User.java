package io.sinsabridge.plants.domain.user;

import com.google.common.base.Strings;
import io.sinsabridge.plants.common.entity.AbstractEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "users")
@SQLDelete(sql = "UPDATE users SET deleted = true WHERE user_no = ?")
public class User extends AbstractEntity implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userNo;

    @Column(nullable = false)
    private String id;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String phone;

    @Column(columnDefinition = "default false", nullable = false)
    private boolean verified;

    private String likePlants;

    @Builder
    public User(String id, String password, String phone, String likePlants) {
        if(Strings.isNullOrEmpty(id)) throw new IllegalArgumentException("empty id");
        if(Strings.isNullOrEmpty(password)) throw new IllegalArgumentException("empty password");
        if(Strings.isNullOrEmpty(phone)) throw new IllegalArgumentException("empty phone");

        this.id = id;
        this.password = password;
        this.phone = phone;
        this.likePlants = likePlants;
    }

    /**
     * 회원정보를 수정한다.
     * @param updateUserDto
     */
    public void update(UserDto.UpdateUser updateUserDto) {
        this.phone = updateUserDto.getPhone();
        this.password = updateUserDto.getPassword();
        this.likePlants = updateUserDto.getLikePlants();
    }

    // security override
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.emptyList();
    }

    @Override
    public String getUsername() {
        return id;
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
