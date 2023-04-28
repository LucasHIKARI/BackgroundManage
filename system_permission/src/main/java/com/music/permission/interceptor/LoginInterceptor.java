package com.music.permission.interceptor;

import com.music.permission.utils.BaseController;
import com.music.permission.utils.JwtUtils;
import com.music.permission.vo.LoginVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.TimeUnit;

/**
 *
 * 进行token续期
 */
@Component
public class LoginInterceptor extends BaseController implements HandlerInterceptor {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

//    前置处理器
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String cktoken = super.getCookieVal(request, "token");
        String hdtoken = request.getHeader("token");
        String token = (hdtoken == null || "".equals(hdtoken)) ? cktoken : hdtoken;
        //token在redis层面是否过期
        ValueOperations ops = stringRedisTemplate.opsForValue();
        Object val = ops.get(token);
        //redis层面token过期，重定向到登陆页面
        if (val == null) {
//            前后端不分离的可以以用视图解析器写成下面这样
//            response.sendRedirect("/users/login");
            request.getRequestDispatcher("/login").forward(request, response);
            return false;
        }
        //redis层面未过期,jwt层面过期.则续期
        LoginVo sysUserProb = JwtUtils.getObject(val.toString(), LoginVo.class);
        if (sysUserProb == null) {
            LoginVo sysUser = JwtUtils.getObjectWithoutValidate(val.toString(), LoginVo.class);
            String ntoken = JwtUtils.getToken(sysUser, 20 * 60 * 1000);
            ops.set(token, ntoken, 40 * 60 * 1000, TimeUnit.MILLISECONDS);
        }

        //redis层面未过期,jwt层面也未过期,则直接放行.
        return true;
    }

//    因为 Spring Boot 的实现类 WebMvcConfigurerAdapter 默认提供了空实现，因此如果不需要对应的功能可以不实现。
//    SSM中如果不需要实现这两个方法，可以直接将方法体留空或者删除，这样不会影响项目运行。
//    postHandle 和 afterCompletion 方法是 HandlerInterceptor 接口中定义的两个方法，用于在请求处理完成后进行后续处理。

//    postHandle 方法在请求处理完成后但在视图渲染之前调用，可以在这个方法中对返回的数据进行修改或者进行日志记录等操作。
//    afterCompletion 方法在视图渲染之后调用，可以在这个方法中进行一些资源清理或者日志记录等操作。

}
