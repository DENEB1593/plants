package io.sinsabridge.plants.domain.user;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/users")
@RestController
@RequiredArgsConstructor
public class UserApiController {

    private final UserService userService;

    /**
     * 회원 등록
     */
    @PostMapping
    public void createUser(@RequestBody UserDto userDto) {
        userService.createUser(userDto);
    }

    /**
     * 회원 조회 by 아이디
     */
    @GetMapping(path = "/{userNo}")
    public void getUser(@PathVariable("userNo") Long userNo) {
        UserInfo userInfo = userService.getUserByUserNo(userNo);
    }

    /**
     * 회원 정보 수정
     */
    @PutMapping
    public void updateUser(@RequestBody UserDto userDto) {
        UserInfo userInfo = userService.updateUser(userDto);
    }

    /**
     * 회원 탈퇴
     */
    @DeleteMapping(path = "/{userNo}")
    public void deleteUser(@PathVariable("userNo") Long userNo) {
        userService.deleteUser(userNo);
    }
}
