package com.louis.mango.admin.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 跨域设置
 *
 * @quthor haMi
 * @date2019/10/19
 */
@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        //允许跨域访问路径
        registry.addMapping("/**")
                //允许跨域访问源
                .allowedOrigins("*")
                //允许请求方法
                .allowedMethods("POST", "GET", "PUT", "OPTIONS", "DELETE")
                //预检间隔时间
                .maxAge(1680000)
                //允许头部设置
                .allowedHeaders("*")
                //是否发送cookie
                .allowCredentials(true);
    }


}
