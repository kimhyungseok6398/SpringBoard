package org.project.configs.Interceptors;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

// 화면설정관련

/** 사이트 설정 유지
 *
 */
@Component
public class SiteConfigInterceptors implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 관리자에서 바꿀수 있다??
       request.setAttribute("cssVersion",1);

        return HandlerInterceptor.super.preHandle(request, response, handler);
    }
}
