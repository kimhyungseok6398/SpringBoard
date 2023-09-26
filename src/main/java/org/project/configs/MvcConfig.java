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
//설정의 틀
@Configuration
@RequiredArgsConstructor
public class MvcConfig implements WebMvcConfigurer {

    @Value("${file.upload.path}")
    private String fileUploadPath;

    //사이트 설정유지 인터셉터
    //@RequiredArgsConstructor로 인해 주입됨
    //SiteCofigInterceptordptj @Component 넣어줘야함
    private final SiteConfigInterceptors siteConfigInterceptor;
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        WebMvcConfigurer.super.addViewControllers(registry);
    registry.addViewController("/")
            .setViewName("main/index");
            // 임시로 설정 바뀔수 있음
            // 인터페이스 설정 잘 기억하기
    }


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        WebMvcConfigurer.super.addResourceHandlers(registry);
    registry.addResourceHandler("/uploads/**")
            .addResourceLocations("file:///"+fileUploadPath);
    }

    @Override    // 기본설정도 볼수있게??
    public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(siteConfigInterceptor)
            .addPathPatterns("/**");//모든 URL에 해당할수 있게
    }
}
