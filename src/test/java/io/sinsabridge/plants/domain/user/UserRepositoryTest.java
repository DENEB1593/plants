package io.sinsabridge.plants.domain.user;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @DisplayName("회원_생성_테스트")
    @Rollback(false)
    @Test
    @Order(1)
    public void createUser() {
        User user = givenUser();

        userRepository.save(user);

        Assertions.assertEquals(1, userRepository.findAll().size());
    }

    @DisplayName("회원_정보수정_테스트")
    @Test
    @Order(2)
    public void updateUser() {
        User someUser = userRepository.findById("deneb1593").orElse(null);
        UserDto updateUserInfo = givenUpdatedUserInfo();

        someUser.update(updateUserInfo);

        Assertions.assertAll(
                () -> Assertions.assertEquals("5678", someUser.getPassword()),
                () -> Assertions.assertEquals("HERB", someUser.getLikePlants())
        );
    }


    @DisplayName("회원_탈퇴_테스트")
    @Test
    @Order(3)
    public void deleteUser() {
        final String userId = "deneb1593";

        userRepository.deleteByUserNo(1L);

        User deletedUser = userRepository.findByUserNo(1L).orElse(null);

        Assertions.assertTrue(deletedUser.isDeleted());

    }

    private static User givenUser() {
        UserDto userDto = new UserDto();
        userDto.setId("deneb1593");
        userDto.setPassword("1234");
        userDto.setPhone("01012341234");
        userDto.setLikePlants("FOLIAGE,TREE,SEED");

        return userDto.toEntity();

    }

    private static UserDto givenUpdatedUserInfo() {
        UserDto userDto = new UserDto();
        userDto.setPassword("5678");
        userDto.setLikePlants("HERB");

        return userDto;
    }


}