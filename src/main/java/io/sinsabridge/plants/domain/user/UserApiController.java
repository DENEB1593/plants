package io.sinsabridge.plants.domain.user;

import io.sinsabridge.plants.common.response.CommonResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/users")
@RestController
@RequiredArgsConstructor
public class UserApiController {

    private final UserService userService;

    /**
     * 회원 등록
     * @return
     */
    @PostMapping
    public CommonResponse<?> createUser(@RequestBody UserDto userDto) {
        userService.createUser(userDto);
        return CommonResponse.success(null, "회원등록 성공");
    }

    /**
     * 문자 인증번호 발송
     */
    @PostMapping("/verify")
    public void verify(@RequestBody VerifyDto verifyDto) {
        userService.sendVerifyCode(verifyDto);
    }

    @PostMapping("/verify-code")
    public void verifyCode(@RequestBody VerifyDto verifyDto) {
        userService.validVerifyCode(verifyDto);
    }

    /**
     * 회원 조회 by 아이디
     */
    @GetMapping(path = "/{userNo}")
    public CommonResponse<UserInfo> getUser(@PathVariable("userNo") Long userNo) {
        UserInfo userInfo = userService.getUserByUserNo(userNo);
        return CommonResponse.success(userInfo, "회원조회 성공");
    }

    /**
     * 회원 정보 수정
     */
    @PutMapping
    public CommonResponse<UserInfo> updateUser(@RequestBody UserDto userDto) {
        UserInfo userInfo = userService.updateUser(userDto);
        return CommonResponse.success(userInfo, "회원정보 수정 성공");
    }

    /**
     * 회원 탈퇴
     */
    @DeleteMapping(path = "/{userNo}")
    public CommonResponse<?> deleteUser(@PathVariable("userNo") Long userNo) {
        userService.deleteUser(userNo);
        return CommonResponse.success(null, "회원정보 삭제 성공");
    }
}
