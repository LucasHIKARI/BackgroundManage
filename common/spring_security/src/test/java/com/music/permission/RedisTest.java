//package com.music.permission;
//
//import cn.hutool.core.util.IdUtil;
//import cn.hutool.core.util.RandomUtil;
//import com.avatar.model.User;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.data.redis.core.RedisTemplate;
//
//import java.util.Date;
//
///**
// * com.avatar.redis
// * Description:
// * @Auther: Lucas
// * @Date: 2023/1/11/011 13:15
// * @Description:
// */
//@SpringBootTest
//public class RedisTest {
//
//    @Autowired
//    private RedisTemplate<Object, Object> redisTemplate;
//
//    @Test
//    public void setValue() {
//        redisTemplate.opsForValue().set("avatar:message-service:token", RandomUtil.randomNumbers(10));
//    }
//
//    @Test
//    public void setEntity() {
//        User user = new User();
//        user.setUserName("张三");
//        user.setPassword(IdUtil.randomUUID());
//        user.setBirthday(new Date());
//        user.setPhoneNumber("12345676543");
//        user.setAge(23);
//        redisTemplate.opsForValue().set("avatar:message-service:user", user);
//        System.out.println("保存成功");
//        User printUser = (User) redisTemplate.opsForValue().get("avatar:message-service:user");
//        System.out.println("从redis中获取值：" + printUser);
//    }
//
//}
