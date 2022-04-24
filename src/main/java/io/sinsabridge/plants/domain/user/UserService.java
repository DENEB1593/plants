package io.sinsabridge.plants.domain.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserInfo createUser(UserDto userDto) {
        // id 중복 검사
        userRepository.findById(userDto.getId()).ifPresent((existedUser) ->{
            throw new RuntimeException(String.format("아이디 %s가 이미 존재합니다.", existedUser.getId()));
        });

        // 회원 저장
        User createdUser = userRepository.save(userDto.toEntity());

        return new UserInfo(createdUser);
    }

    @Transactional(readOnly = true)
    public UserInfo getUserByUserNo(Long userNo) {
        User user = userRepository.findByUserNo(userNo)
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
