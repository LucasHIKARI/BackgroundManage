package com.music.permission.config;


import com.music.permission.service.UserDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsUtils;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * @Auther: Lucas
 * @Date: 2022/12/21/001 22:22
 * @Description:
 */

//@Configuration
//@EnableWebSecurity /*开启security*/
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

//    暫時關閉一切功能
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().anyRequest().permitAll().and().csrf().disable();
    }

//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//
////        // 开启跨域访问
////        http.cors(); //.disable();
////        // 开启模拟请求，比如API POST测试工具的测试，不开启时，API POST为报403错误
////        http.csrf().disable();
////        // iframe 跳转错误处理 Refused to display 'url' in a frame because it set 'X-Frame-Options' to 'deny'
////        http.headers().frameOptions().disable();
////        // 当出现跨域的OPTIONS请求时，发现被拦截，加入下面设置可实现对OPTIONS请求的放行。
////        http.authorizeRequests().
////                requestMatchers(CorsUtils::isPreFlightRequest).
////                permitAll();
//
//        http.cors().and()/*.addFilterBefore(corsFilter(), UsernamePasswordAuthenticationFilter.class)*/
//
//                .authorizeRequests()
//                //处理跨域请求中的Preflight请求
//                .requestMatchers(CorsUtils::isPreFlightRequest).permitAll()
//                .antMatchers(HttpMethod.GET,"/hello/hello").permitAll()
//                .antMatchers("/user-manage/*").permitAll()
//                .antMatchers(HttpMethod.GET,"/user-manage/*/*").permitAll()
//                .antMatchers(HttpMethod.GET,"/user-manage/*/*/*").permitAll()
//                .antMatchers(HttpMethod.GET,"/user-manage/*/*/*/*").permitAll()
//                .antMatchers(HttpMethod.GET,"/right-manage/role/*").permitAll()
//                .antMatchers(HttpMethod.GET, "/right-manage/role/*/*").permitAll()
//                .antMatchers(HttpMethod.GET, "/right-manage/right/*").permitAll()
//                .antMatchers(HttpMethod.GET,"/right-manage/right/*/*").permitAll()
//                .antMatchers(HttpMethod.GET,"/login","/login2").permitAll()
//                //spring security默认不能用get请求，在这里允许get
//                .antMatchers(HttpMethod.GET,
//                        "/",
//                        "/home",
//                        "/find",
//                        "/mymusic",
//                        "/guess",
//                        "/songlist",
//                        "/share-forum",
//                        "/mypage",
//                        "/commonPage/*"
//
//                ).permitAll()
//                .anyRequest().authenticated()
//                .and().cors() // 跨域需要添加此配置项
//                .and().csrf().disable()
//                .formLogin()
////        自定义登陆页
////               .loginPage("/login")
//                .defaultSuccessUrl("/home")
////              .loginProcessingUrl("/user/login");// 自定义登录 action, 名字随便起
////                .passwordParameter("password") // 配置 form 表单 密码的 name 属性值
////                .usernameParameter("username") /*配置 form 表单 用户名的 name 属性值*/
//                .permitAll()
//                .and()
//                .logout()
//
//                .permitAll();
//
//        http.logout().logoutSuccessUrl("/"); // 登出后跳转首页
//        http.rememberMe().rememberMeParameter("remember"); // 记住我勾选框
//    }


    @Bean
    public CorsFilter corsFilter() {
        return new CorsFilter(new UrlBasedCorsConfigurationSource());
    }
    /**
     * 自定义登录校验处理
     *
     * @return
     */
    @Bean
    public UserDetailsService userDetailsService() {
        return new UserDetailServiceImpl();
    }

//    AuthenticationManager进行用户认证
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    /**
     * 加密工具
     * 2.x 版本的 spring-security-starter 必须加上
     *
     * @return
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
    }

   /* @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
            .withUser("user").password("password").roles("USER"); *//* 设置用户信息，实际开发要从数据库中读取*//*

    }*/

}