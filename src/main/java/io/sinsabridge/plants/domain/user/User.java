package io.sinsabridge.plants.domain.user;

import com.google.common.base.Strings;
import io.sinsabridge.plants.common.entity.AbstractEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;

import javax.persistence.*;
import java.util.Objects;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "users")
@SQLDelete(sql = "UPDATE users SET deleted = true WHERE id=?")
public class User extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userNo;

    @Column(nullable = false)
    private String id;

    @Column(nullable = false)
    private String password;

    private String email;

    @Column(nullable = false)
    private String phone;

    @Enumerated(EnumType.STRING)
    private PlantType plantType;

    @Builder
    public User(String id, String password, String email, String phone) {
        if(Strings.isNullOrEmpty(id)) throw new IllegalArgumentException("empty id");
        if(Strings.isNullOrEmpty(password)) throw new IllegalArgumentException("empty password");
        if(Strings.isNullOrEmpty(email)) throw new IllegalArgumentException("empty email");
        if(Strings.isNullOrEmpty(phone)) throw new IllegalArgumentException("empty phone");

        this.id = id;
        this.password = password;
        this.email = email;
        this.phone = phone;
    }

    /**
     * 회원정보를 수정한다.
     * @param userDto
     */
    public void update(UserDto userDto) {
        this.email = userDto.getEmail();
        this.password = userDto.getPassword();
        this.phone = userDto.getPhone();
    }
}
