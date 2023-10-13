package org.project.configs;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration // 스프링에서 설정클래스로 인식
public class SecurityConfig {
// 북따옴엔 없음
    @Bean // 스프링이 관리하는 객체
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
    return http.build(); // 추후 설정 결정
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer(){
        return w -> w.ignoring().requestMatchers("/css/**", "/js/**","/images/**","/error/**");
        // 정적경로 설정 상관없이 접근 가능하게 설정
        // 레이아웃 설정후 해제 예정
    }

}
