package io.sinsabridge.plants.domain.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserInfo createUser(UserDto userDto) {
        final User createdUser = userRepository.save(userDto.toEntity());
        return new UserInfo(createdUser);
    }

    @Transactional(readOnly = true)
    public UserInfo getUserByUserNo(Long userNo) {
        final User user = userRepository.findByUserNo(userNo)
                .orElseThrow(() -> new RuntimeException(String.format("User not found : %s", userNo)));

        return new UserInfo(user);
    }

    public UserInfo updateUser(UserDto userDto) {
        User user = userRepository.findById(userDto.getId())
                .orElseThrow(() -> new RuntimeException(String.format("User not found : %s", userDto.getId())));

        user.update(userDto);

        return new UserInfo(user);
    }

    public int deleteUser(Long userNo) {
        return userRepository.deleteByUserNo(userNo);
    }
}
