package com.pohinian.springvue.security;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Park Ji Hoon (pohinian@gmail.com) on 2018. 4. 16..
 */
@Component
public class HttpAuthenticationEntryPoint implements AuthenticationEntryPoint {


    /**
     * 미인증 사용자가 Url 접근 시 Default 페이지로 날리는 것을 막고 인증 실패 메시지만 리턴해주기 위한 설정
     * Default 페이지로 날리는건 프론트엔드에서 하자.
     * */
    @Override
    public void commence(HttpServletRequest httpServletRequest,
                         HttpServletResponse httpServletResponse, AuthenticationException e)
            throws IOException {
        httpServletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED, e.getMessage());
    }
}
