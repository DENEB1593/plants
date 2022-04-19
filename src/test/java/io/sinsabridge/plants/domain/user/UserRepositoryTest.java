package io.sinsabridge.plants.domain.user;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @DisplayName("회원_생성_테스트")
    @Test
    public void createUser() {
        User user = givenUser();

        userRepository.save(user);

        Assertions.assertEquals(1, userRepository.findAll().size());
    }

    private static User givenUser() {
        UserDto userDto = new UserDto();
        userDto.setId("deneb1593");
        userDto.setPassword("1234");
        userDto.setPhone("01012341234");
        userDto.setEmail("deneb1593@gmail.com");

        return userDto.toEntity();

    }

}