package org.project.configs;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.project.configs.Interceptors.SiteConfigInterceptors;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//설정의 틀 스프링 부트시 필요한것만 사용함
// 인터페이스 설정
// 오버라이드 설정
@Configuration
@RequiredArgsConstructor
public class MvcConfig implements WebMvcConfigurer {
    // 스프링 빈으로 등록된 객체에서 properties파일이나
    // 환경변수등의 값을 주입받을때 사용
    @Value("${file.upload.path}")
    private String fileUploadPath;

    //사이트 설정유지 인터셉터
    //@RequiredArgsConstructor로 인해 주입됨
    //SiteCofigInterceptordptj @Component 넣어줘야함

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
    registry.addViewController("/")
            .setViewName("main/index");
            // 템플릿을 만들기 위해 임시로 설정
            // 임시로 설정 바뀔수 있음
            // 인터페이스 설정 잘 기억하기
            // 레이아웃 설정후 삭제예정
    }

    // 정적경로들을 주로 설정하기 위해 사용
    // 파일들의 URL등을 설정
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
    registry.addResourceHandler("/uploads/**")
            .addResourceLocations("file:///" + fileUploadPath);
    // 경로 설정
    }

}
