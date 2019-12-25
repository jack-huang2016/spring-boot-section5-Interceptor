package org.springboot.sample.config;

import org.springboot.sample.interceptor.MyInterceptor1;
import org.springboot.sample.interceptor.MyInterceptor2;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import java.util.ArrayList;
import java.util.List;

/**
 * 在spring boot2.x中，继承 WebMvcConfigurerAdapter已经过时，所以在Springboot2.0以上，更好的做法还是实现WebMvcConfigurer
 */
@Configuration
public class MyWebAppConfigurer implements WebMvcConfigurer {

	@Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 多个拦截器组成一个拦截器链
        // addPathPatterns 用于添加拦截规则
        registry.addInterceptor(new MyInterceptor1()).addPathPatterns("/**");

        // excludePathPatterns 用户排除拦截
        // 用户排除拦截的路径集合
        List<String> excludePathList = new ArrayList<>();
        String excludePath1 = "/login";
        //String excludePath2 = "/common/send";
        //String excludePath3 = "/common/validationCode";
        excludePathList.add(excludePath1);
        //excludePathList.add(excludePath2);
        //excludePathList.add(excludePath3);

        registry.addInterceptor(new MyInterceptor2()).addPathPatterns("/**").excludePathPatterns(excludePathList);
        WebMvcConfigurer.super.addInterceptors(registry);
    }
}
