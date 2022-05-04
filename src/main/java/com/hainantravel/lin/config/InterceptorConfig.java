package com.hainantravel.lin.config;

/**
 * @author: Lin
 * @time: 2021/1/4 16:32
 * @Description: 拦截器配置
 */

import com.hainantravel.lin.interceptor.JwtInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new JwtInterceptor()) //添加拦截器JwtInterceptor到拦截器中
              .addPathPatterns("/**")         //拦截所有路径
              .excludePathPatterns("/api/administrator_login2")//但排除登录路径
                .excludePathPatterns("/upload/**"); //但排除静态资源
    }

    //文件上传虚拟路径和绝对路径映射
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/upload/**").addResourceLocations("file:/travel/upload/img");

    }
}
