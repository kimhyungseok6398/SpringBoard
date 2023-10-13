package org.project.configs.Interceptors;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

// 화면설정관련
// 오버라이드 설정

/** 사이트 설정 유지
 *
 */
@Component // 꼭 넣어야됨 mvcCofig 참고
public class SiteConfigInterceptor implements HandlerInterceptor {
    // 요청전에 해야하기에 preHandle / 공통적인 기능 / 접근제어 기능 ( 시큐리티는 필요 없음 )
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 관리자에서 바꿀수 있다??
       request.setAttribute("cssVersion",1);

        return true;
    }
}
