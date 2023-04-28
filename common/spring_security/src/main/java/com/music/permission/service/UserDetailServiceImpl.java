package com.music.permission.service;

import com.alibaba.fastjson.JSON;
import com.music.permission.mapper.LoginMapper;
import com.music.permission.result.Result;
import com.music.permission.util.JwtUtil;
import com.music.permission.util.JwtUtil2;
import com.music.permission.util.RedisCache;
import com.music.permission.utils.MD5;
import com.music.permission.vo.LoginUser;
import com.music.permission.vo.LoginVo;
import jdk.jshell.spi.ExecutionControl;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.*;


/**
 * @Auther: Lucas
 * @Date: 2023/1/10/010 14:12
 * @Description:
 */
public class UserDetailServiceImpl implements UserDetailsService {

    /*    @Autowired
        private PasswordEncoder passwordEncoder;*/
    @Autowired
    LoginMapper loginMapper;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private RedisCache redisCache;

    public static void main(String[] args) {
        System.out.println(new BCryptPasswordEncoder().encode("123456"));// $2a$10$g1gzj4KvMNY1kMZT1xDx9ufLuaDvCFDpX.PdETx85zQwXI/Mn4ttC
    }

    /**
     * @param username 登录页面输入的用户名
     * @return
     * @throws UsernameNotFoundException
     */
    /* @Override*/
    public /*UserDetails*/ LoginVo loadUserByUsername2(String username,String password) throws UsernameNotFoundException {
        // TODO 根据 username 去用户表查询出来用户的信息，然后进行验证
        List<LoginVo> loginVos = loginMapper.loginByUserName(username);
        //如果用户不存在
        if (Objects.isNull(loginVos) || loginVos.isEmpty()) {
            throw new RuntimeException("用户名不存在");
        }


        // 判断密码是否一致
        String md5Password = MD5.encrypt(password);
        for (LoginVo loginUser : loginVos) {
            if (loginUser.getPassword().equals(md5Password)) {
                List<String> rights = new ArrayList<>();

                for (LoginVo loginVo : loginVos) {
                    if (loginVo.getPath() != null) {
                        rights.add(loginVo.getPath());
                    }
                }

                loginUser.setRights(rights);

                return loginUser;
            }
        }

        throw new RuntimeException("密码错误");
//        String md5Password = MD5.encrypt(password);
//        for (LoginVo loginUser : loginVos) {
//            if(!loginUser.getPassword().equals(md5Password)) {
//                throw new ExecutionControl.UserException(20001,"密码不正确");
//                throw new RuntimeException("用户名或者密码错误");
//            }
//            return loginUser;
//        }
//
//        String md5Password = MD5.encrypt(password);
//        for (LoginVo loginUser : loginVos) {
//            if(loginUser.getPassword().equals(md5Password)) {
//                return loginUser;
//            }
//        }

//暂时不用spring security的 authorities封装
//        Collection<GrantedAuthority> authorities = new ArrayList<>();
//
//        for (LoginVo loginVo : loginVos) {
//            if (loginVo.getPath() != null) {
//                authorities.add(new SimpleGrantedAuthority(loginVo.getPath()));
//            }
//        }
//        LoginVo firstLoginVo = loginVos.get(0);
//        String userName = firstLoginVo.getUsername();
//        String password = firstLoginVo.getPassword();
//        User user = new User(userName, password, authorities);
//
//        List<String> rights = new ArrayList<>();
//
//        for (LoginVo loginVo : loginVos) {
//            if (loginVo.getPath() != null) {
//                rights.add(loginVo.getPath());
//            }
//        }
//        LoginVo firstLoginVo = loginVos.get(0);
//        String userName = loginUser.getUsername();
//        String password = loginUser.getPassword();
//
//        loginVos.get(0).setRights(rights);
        // 验证成功后，返回Spring-Security 提供的 User 对象
        // 对应三个构造参数依次是： 1.用户名 2.密码（经过 passwordEncoder 加密后的密码） 3.权限列表
        // return new User(username, "$2a$10$g1gzj4KvMNY1kMZT1xDx9ufLuaDvCFDpX.PdETx85zQwXI/Mn4ttC", AuthorityUtils.createAuthorityList("admin"));

//        return loginVos.get(0);

    }

    public Result login(LoginVo loginVo) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(loginVo.getUsername(), loginVo.getPassword());
        Authentication authenticate = authenticationManager.authenticate(authenticationToken);
        //如果认证没通过，给出对应的提示
        if (Objects.isNull(authenticate)) {
            throw new RuntimeException("登录失败");
        }
        //如果认证通过了，使用userid生成一个jwt jwt存入ResponseResult返回
        LoginUser loginUser = (LoginUser) authenticate.getPrincipal();
        String userId = loginUser.getLoginVo().getUserId().toString();

        String jwt = JwtUtil2.createJWT(userId);
        Map<String, String> map = new HashMap<>();
        map.put("token", jwt);
        //把完整的用户信息存入redis  userid作为key
        redisCache.setCacheObject("login:" + userId, loginUser);
        return Result.ok(map);

    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return null;
    }
}