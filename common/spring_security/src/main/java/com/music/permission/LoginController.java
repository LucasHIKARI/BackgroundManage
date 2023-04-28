package com.music.permission;
import com.music.permission.result.Result;
import com.music.permission.service.UserDetailServiceImpl;
import com.music.permission.vo.LoginVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: Lucas
 * @Date: 2023/1/1/001 16:39
 * @Description:
 */
//@CrossOrigin
//@RestController
/*@RequestMapping("/users/login")*/
public class LoginController {

    @Autowired
    UserDetailsService userDetailsService;

    @Autowired
    UserDetailServiceImpl userDetailsServiceImpl;

    @Autowired
    private AuthenticationManager authenticationManager;


    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginVo loginVo) {
        try {
            String username = loginVo.getUsername();
            String password = loginVo.getPassword();
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
            return ResponseEntity.ok("登录成功");
        } catch (AuthenticationException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("用户名或密码错误");
        }
    }



    @PostMapping("/login2")
    public Result login2(@RequestBody LoginVo loginVo) {

        String username = loginVo.getUsername();
        String password = loginVo.getPassword();
        System.out.println(username);
        LoginVo user = userDetailsServiceImpl.loadUserByUsername2(username,password);

//        UserDetails user = userDetailsService.loadUserByUsername(username);
//        Map<String,String> map = new HashMap<>();
//        map.put("token",user);

//        String jsonString = JSON.toJSONString(user);
//        String jwt = JwtUtil2.createJWT(jsonString);//这个方法有问题 原因可能有：1.缺少相关的jar包；2.jar包版本不兼容；3.类路径配置错误。
//        Map<String,String> map = new HashMap<>();
//        map.put("token",jwt);
        //把完整的用户信息存入redis  userid作为key
//        redisCache.setCacheObject("login:"+userId,loginUser);

        return Result.ok(user);
    }

    //login
    //{"code":20000,"data":{"token":"admin-token"}}
//    @PostMapping("/login")
//    public Result login(@RequestBody LoginVo loginVo) {
//        //根据username查询数据
//        UserVo sysUser = sysUserService.getUserInfoByUserName(loginVo.getUsername());
//
//        //判断用户是否可用
//        if(sysUser.getStatus().intValue()==0) {
//            throw new UserException(401,"用户已经被禁用");
//        }
//
//        //如果查询为空
//        if(sysUser == null) {
//            throw new UserException(20001,"用户不存在");
//        }
//
//        //判断密码是否一致
//        String password = loginVo.getPassword();
//        String md5Password = MD5.encrypt(password);
//        if(!sysUser.getPassword().equals(md5Password)) {
//            throw new UserException(20001,"密码不正确");
//        }
//
//
//
//        //根据userid和username生成token字符串，通过map返回
//        String userId =sysUser.getId().toString();
//        String token = JwtHelper.createToken(userId, sysUser.getUsername());
//
//        Map<String,Object> map = new HashMap<>();
//        map.put("token",token);
//        return Result.ok(map);
//    }

    //info
//    {"code":20000,"data":{"roles":["admin"],
//        "introduction":"I am a super administrator",
//                "avatar":"https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif",
//                "name":"Super Admin"}}


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