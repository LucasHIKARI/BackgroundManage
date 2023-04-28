package com.music.permission.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: Lucas
 * @Date: 2023/1/1/001 22:37
 * @Description:
 */
@RestController
public class homeController {


        @GetMapping("/home")
        public String hello() {
            return "hello home";
        }

}