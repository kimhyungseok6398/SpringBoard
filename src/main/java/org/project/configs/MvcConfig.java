package org.project.configs;

import lombok.RequiredArgsConstructor;
import org.project.configs.Interceptors.SiteConfigInterceptor;
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
@RequiredArgsConstructor // 인터셉터를 주입받기위해
public class MvcConfig implements WebMvcConfigurer {
    // 스프링 빈으로 등록된 객체에서 properties파일이나
    // 환경변수등의 값을 주입받을때 사용
    @Value("${file.upload.path}")
    private String fileUploadPath;

    //@RequiredArgsConstructor 어노테이션을 사용하기에
    //final이 사용된 부분은 생성자 매개변수로 추가가됨
    //사이트 설정 유지 인터셉터
    private final SiteConfigInterceptor siteConfigInterceptor;

    //사이트 설정유지 인터셉터
    //@RequiredArgsConstructor사용으로 주입되며
    //SiteCofigInterceptor 쪽에서  @Component 넣어줘야함

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

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
     registry.addInterceptor(siteConfigInterceptor)
             .addPathPatterns("/**");
    }
}
