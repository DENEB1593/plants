package io.sinsabridge.plants.domain.user;

import com.google.common.collect.Lists;
import io.sinsabridge.plants.domain.user.exception.UserAlreadyExistException;
import io.sinsabridge.plants.domain.user.exception.UserNotFoundException;
import io.sinsabridge.plants.infra.notification.SendManger;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    @Qualifier("smsSendManger")
    private final SendManger smsSendManger;

    private final UserRepository userRepository;

    /**
     * 회원 등록
     * @param createUserDto
     * @return
     */
    public UserInfo createUser(UserDto.CreateUser createUserDto) {
        // id 중복 검사
        userRepository.findById(createUserDto.getId()).ifPresent(user -> {
            throw new UserAlreadyExistException();
        });

        // 회원 저장
        User createdUser = userRepository.save(createUserDto.toEntity());

        return new UserInfo(createdUser);
    }

    /**
     * 인증번호 발송
     * @param verifyDto
     */
    public void sendVerifyCode(VerifyDto verifyDto) {
        ResponseEntity<String> result = smsSendManger.send(verifyDto);
        log.info("{}", result);
    }

    /**
     * 인증번호 검증
     * @param verifyDto
     */
    public void validVerifyCode(VerifyDto verifyDto) {
        userRepository.findByPhone(verifyDto.getPhone());
    }

    @Transactional(readOnly = true)
    public UserInfo getUserByUserNo(Long userNo) {
        User user = userRepository.findByUserNo(userNo).orElseThrow(UserNotFoundException::new);

        return new UserInfo(user);
    }

    /**
     * 회원 정보 수정
     * @param userDto
     */
    public UserInfo updateUser(UserDto.UpdateUser updateUserDto) {
        User user = userRepository.findById(updateUserDto.getId()).orElseThrow(UserNotFoundException::new);

        user.update(updateUserDto);
        userRepository.save(user);

        return new UserInfo(user);
    }

    public int deleteUser(Long userNo) {
        return userRepository.deleteByUserNo(userNo);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findById(username).orElseThrow(UserNotFoundException::new);

        return org.springframework.security.core.userdetails
                        .User.builder()
                        .username(user.getId())
                        .password(user.getPassword())
                        .authorities(Lists.newArrayList(new SimpleGrantedAuthority("USER")))
                        .build();
    }
}
