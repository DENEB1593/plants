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

    private static final String TEST_ID = "deneb1593";

    @DisplayName("회원_생성_테스트")
    @Rollback(false)
    @Test
    @Order(1)
    public void createUser() {
        User user = givenUser();

        userRepository.save(user);

        Assertions.assertNotNull(userRepository.findById(TEST_ID).orElse(null));
    }

    @DisplayName("회원_정보수정_테스트")
    @Test
    @Order(2)
    public void updateUser() {
        User someUser = userRepository.findById(TEST_ID).orElse(null);
        UserDto.UpdateUser updateUserInfo = givenUpdatedUserInfo();

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
        userRepository.deleteByUserNo(1L);

        User deletedUser = userRepository.findByUserNo(1L).orElse(null);

        Assertions.assertTrue(deletedUser.isDeleted());

    }

    private static User givenUser() {
        UserDto.CreateUser createUser = new UserDto.CreateUser(TEST_ID, "1234", "01012341234", "FOLIAGE,TREE,SEED");
        return createUser.toEntity();

    }

    private static UserDto.UpdateUser givenUpdatedUserInfo() {
        return new UserDto.UpdateUser(TEST_ID, "01012341234", "5678", "HERB");
    }


}