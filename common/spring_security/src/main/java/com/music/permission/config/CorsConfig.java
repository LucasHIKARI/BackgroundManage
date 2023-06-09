package com.music.permission.config;

/**
 * @Auther: Lucas
 * @Date: 2023/2/9/009 13:51
 * @Description:
 */

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
//
///**
// * 跨域过滤器
// * @author owen
// * @since 2022/5/1 20:53
// */
//@Configuration
//public class CorsConfig implements WebMvcConfigurer {
//
//
//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//        // 设置允许跨域的路径
//        registry.addMapping("/**")
//
//                .allowedOriginPatterns("*")// 设置允许跨域请求的域名
//                .allowCredentials(true)   // 是否允许cookie
//                .allowedMethods("GET", "POST", "DELETE", "PUT") // 设置允许的请求方式
//                .allowedHeaders("*") // 设置允许的header属性
//                .maxAge(3600);// 跨域允许时间
//    }
//
//}
