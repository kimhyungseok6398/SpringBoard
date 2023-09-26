package org.project.configs;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
// 북따옴엔 없음
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
    return http.build(); // 추후 설정 결정
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer(){
        return w->w.ignoring().requestMatchers("/css/**", "/js/**","/images/**","/error/**");

    }

}
