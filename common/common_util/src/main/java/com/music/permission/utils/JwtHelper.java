package com.music.permission.utils;

import io.jsonwebtoken.*;
import org.springframework.util.StringUtils;

import java.util.Date;

/**
 * 生成JSON Web令牌的工具类
 */
public class JwtHelper {

    //token过期时间
    private static long tokenExpiration = 7 * 24 * 60 * 60 * 1000;
    //加密秘钥
    private static String tokenSignKey = "123456";

    //根据用户id和用户名称生成token字符串
    public static String createToken(String userId, String username) {
        String token = Jwts.builder()
//                进行分组
                .setSubject("AUTH-USER")
//                设置过期时间
                .setExpiration(new Date(System.currentTimeMillis() + tokenExpiration))
//                设置有效载荷（加密重要信息）以后自定义
                .claim("userId", userId)
                .claim("username", username)
//                加密
                .signWith(SignatureAlgorithm.HS512, tokenSignKey)
//                压缩处理
                .compressWith(CompressionCodecs.GZIP)
                .compact();
        return token;
    }

    //从token字符串获取userid
    public static String getUserId(String token) {
        try {
            if (StringUtils.isEmpty(token)) return null;

            Jws<Claims> claimsJws = Jwts.parser().setSigningKey(tokenSignKey).parseClaimsJws(token);
            Claims claims = claimsJws.getBody();
            String userId = (String) claims.get("userId");
            return userId;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //从token字符串获取username
    public static String getUsername(String token) {
        try {
            if (StringUtils.isEmpty(token)) return "";

            Jws<Claims> claimsJws = Jwts.parser().setSigningKey(tokenSignKey).parseClaimsJws(token);
            Claims claims = claimsJws.getBody();
            return (String) claims.get("username");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        String token = JwtHelper.createToken("1", "test");
        System.out.println(token);

        String userId = JwtHelper.getUserId(token);
        System.out.println(userId);

        String username = JwtHelper.getUsername(token);
        System.out.println(username);
    }
}