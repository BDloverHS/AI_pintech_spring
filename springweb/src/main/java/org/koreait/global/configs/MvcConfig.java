package org.koreait.global.configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
// 기본적으로 해야할 설정들이 자동 추가
@EnableWebMvc
// 설정 통합
@Import(ControllerConfig.class)
public class MvcConfig implements WebMvcConfigurer {
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
        /**
         * 1. 요청 주소가 유입되었을 때
         * 2. HandlerMapping이 컨트롤러 빈을 검색
         * 3. 못 찾으면 -> css, js, 정적 웹페이지 html, 이미지 등으로 경로를 검색(O)
         */
    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.jsp("/WEB-INF/templates/", ".jsp");
    }

    /**
     * 1. HandlerMapping이 컨트롤러 빈을 찾지 못하면 체크해보는 경로 설정
     *
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
    }
}
