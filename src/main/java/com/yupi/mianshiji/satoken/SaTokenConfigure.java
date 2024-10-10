package com.yupi.mianshiji.satoken;

import cn.dev33.satoken.interceptor.SaInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * TODO
 *
 * @author liyuhang
 * @version 1.0
 * @time 2024-10-10-20:44
 **/
@Configuration
public class SaTokenConfigure implements WebMvcConfigurer {

    //注册 Sa-Token 拦截器 打开注解式鉴权功能
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
    //注册 Sa-Token 拦截器 打开注解式鉴权功能
        registry.addInterceptor(new SaInterceptor()).addPathPatterns("/**");
    }
}
