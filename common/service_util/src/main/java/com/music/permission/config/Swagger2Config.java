//package com.music.permission.config;
//
//import io.swagger.annotations.ApiOperation;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import springfox.documentation.builders.ApiInfoBuilder;
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;
//
///**
// * SwaggerConfig file
// * zhenghui
// */
//@Configuration
//@EnableSwagger2
//@EnableKnife4j //UI
//public class Swagger2Config {
//
//    @Bean
//    public Docket appApi() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .useDefaultResponseMessages(false) //去掉默认的状态响应码
//                .groupName("知识库")
//                .apiInfo(apiInfo())
//                .select()
//
//                //扫描指定的包
////                .apis(RequestHandlerSelectors.basePackage("com.glodon.demo.mybatis")) //扫描的包
//
//                //扫描只包含Swagger的注解，这种方式灵活
//                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
//                .paths(PathSelectors.any())
//                .build();
//
//    }
//
//
//
//    /**
//     * 配置Swagger信息
//     * @return
//     */
//    private ApiInfo apiInfo() {
//        return new ApiInfoBuilder()
//                .title("知识库接口文档")
//                .description("该文档主要提供知识库后端的接口 \r\n\n")
//                .contact(new springfox.documentation.service.Contact("我们是机器人<----q'(^_^)'p---->业务后台开发组", "https://www.glodon.com/", null))
//                .version("0.0.1")
//                .build();
//    }
//
//
//}
