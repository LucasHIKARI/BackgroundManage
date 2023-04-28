package com.music.permission.controller;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.music.permission.result.Result;
import com.music.permission.service.SysUserService;
import com.music.permission.utils.BaseController;
import com.music.permission.utils.JwtUtils;
import com.music.permission.utils.MD5;
import com.music.permission.vo.LoginVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

import static com.music.permission.utils.MD5.MD5WithSalt;
import static com.music.permission.utils.MD5.MD5WithSaltForLogin;

/**
 * @Auther: Lucas
 * @Date: 2023/1/1/001 16:39
 * @Description:
 */
@RestController
@RequestMapping("/users")
public class LoginController2 extends BaseController {

    @Autowired
    private SysUserService sysUserService;

//    @CrossOrigin(origins = "http://localhost:8000", allowCredentials = "true")
//单独跨域设置不生效，前端解析token进行鉴权，最后引入专门的cookie跨域依赖，并自定义配置文件解决
//    @CrossOrigin(origins = "http://localhost:8000",allowCredentials="true",allowedHeaders = "*")
    @PostMapping("/login")
    public Result login(@RequestBody LoginVo loginVo,HttpServletRequest req,HttpServletResponse response) {

//        如果cookie存在有用户信息的token
        String token = super.getCookieVal(req, "token");
        System.out.println(token);
        if(token!=null&!token.equals("")){
            LoginVo tokenObj = JwtUtils.getObjectWithoutValidate(token,LoginVo.class);
            return Result.ok(tokenObj);
            }


        // 设置响应头，允许跨域访问
        response.setHeader("Access-Control-Allow-Origin", "http://localhost:8000");
        response.setHeader("Access-Control-Allow-Credentials", "true");
//      response.setHeader("Access-Control-Allow-Methods", "*");

        String username = loginVo.getUsername();
        List<LoginVo> loginVos = sysUserService.getUserInfoByUserName(username);
        //如果用户不存在
        if (Objects.isNull(loginVos.get(0).getUsername())) {
            throw new RuntimeException("用户名不存在");
        }
        // 判断密码是否一致
        String md5WithSalt = MD5WithSaltForLogin(loginVo.getPassword(), loginVos.get(0).getPassword());
        for (LoginVo loginUser : loginVos) {
            if (loginUser.getPassword().equals(md5WithSalt)) {
                List<String> rights = new ArrayList<>();

                for (LoginVo user : loginVos) {
                    if (user.getPath() != null) {
                        rights.add(user.getPath());
                    }
                }

                loginUser.setRights(rights);
                return Result.ok(loginUser);
            }
        }

        throw new RuntimeException("密码错误");

    }

    // 设置CORS的注解
//    @CrossOrigin(origins = "http://localhost:8080", allowCredentials = "true")
//    @RequestMapping("/login")
//    @ResponseBody
//    public Result login(@RequestBody LoginVo loginVo, HttpServletResponse resp, HttpServletRequest req) {
//
//        String username = loginVo.getUsername();
//        List<LoginVo> loginVos = userService.getUserInfoByUserName(username);
//        //如果用户不存在
//        if (Objects.isNull(loginVos.get(0).getUsername())) {
//
//            Object o = new Object();
//            return Result.fail(o);
////            throw new RuntimeException("用户名不存在");
//        }
//        // 判断密码是否一致
//        String md5WithSalt = MD5WithSaltForLogin(loginVo.getPassword(), loginVos.get(0).getPassword());
//        for (LoginVo loginUser : loginVos) {
//            if (loginUser.getPassword().equals(md5WithSalt)) {
//                List<String> rights = new ArrayList<>();
//
//                for (LoginVo user : loginVos) {
//                    if (user.getPath() != null) {
//                        rights.add(user.getPath());
//                    }
//                }
//
//                loginUser.setRights(rights);
//
//                //生成token,加入redis,redis时间是jwt时间的2倍.
//                loginUser.setPassword("");
//                String token = JwtUtils.getToken(loginUser, 20 * 60 * 1000);
//                ValueOperations ops = redisTemplate.opsForValue();
////                redis中存token
//                ops.set(token, token, 40 * 60 * 1000, TimeUnit.MILLISECONDS);
////                向父cookie中存入token
//                super.setCookieVal(resp,req, "token", token);
//
//                return Result.ok(loginUser);
//            }
//        }
//        throw new RuntimeException("密码错误");
//    }

//    @GetMapping("info")
//    public Result info(HttpServletRequest request) {
//        //获取请求头token字符串
//        String token = request.getHeader("token");
//
//        //从token字符串获取用户名称（id）
//        String username = JwtHelper.getUsername(token);
//
//        //根据用户名称获取用户信息（基本信息 和 菜单权限 和 按钮权限数据）
//        Map<String,Object> map = sysUserService.getUserInfo(username);
//        return Result.ok(map);
//    }


}