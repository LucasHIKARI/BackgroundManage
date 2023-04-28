package com.music.permission;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * 测试类基类
 */
@SpringBootTest
@WebAppConfiguration
public class BaseTestClass {

    @BeforeEach
    public void init(){
        System.out.println("before");
    }

    @AfterEach
    public void after(){
        System.out.println("after");
    }
}

