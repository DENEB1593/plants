package io.sinsabridge.plants.common.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Strings;
import io.sinsabridge.plants.domain.user.UserDto;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.function.Predicate;

public class RestLoginFilter extends AbstractAuthenticationProcessingFilter {

    @Autowired
    private ObjectMapper objectMapper;

    private static Predicate<HttpServletRequest> isRestApiRequest =
            (req) -> "application/json".equals(req.getHeader("Content-type"));

    public RestLoginFilter(ObjectMapper objectMapper) {
        super(new AntPathRequestMatcher("/api/users/login"));
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException, IOException, ServletException {
        if (!isRestApiRequest.test(request)) {
            throw new IllegalStateException("로그인 요청 형식이 올바르지 않습니다");
        }

        UserDto.LoginUser loginUserDto = objectMapper.readValue(request.getReader(), UserDto.LoginUser.class);

        final String id = loginUserDto.getId();
        final String password = loginUserDto.getPassword();

        if (Strings.isNullOrEmpty(id) ||
            Strings.isNullOrEmpty(password)) {
            throw new IllegalStateException("아이디, 비밀번호 값이 유효하지 않습니다");
        }
        UsernamePasswordAuthenticationToken authencationToken = new UsernamePasswordAuthenticationToken(id, password);
        return getAuthenticationManager().authenticate(authencationToken);
    }
}
