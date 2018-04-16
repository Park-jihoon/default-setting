package com.pohinian.springvue.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Park Ji Hoon (pohinian@gmail.com) on 2018. 4. 16..
 */
@Component
public class HttpLogoutSuccessHandler implements LogoutSuccessHandler {



    /**
     * 로그아웃 처리 하기위한 로직
     * */
    @Override
    public void onLogoutSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        if (authentication == null) {
            httpServletResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        } else {
            httpServletResponse.setStatus(HttpServletResponse.SC_OK);

            // TODO 유저 디테일을 구현한 클래스로 Member 를 변환 필요
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();

            PrintWriter pw = httpServletResponse.getWriter();
            pw.write(userDetails.getUsername() + " logout Success");
            pw.flush();

        }
    }
}
