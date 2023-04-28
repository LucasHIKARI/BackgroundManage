package com.music.permission.errorHandler;
import com.music.permission.result.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
/**
 * @Auther: Lucas
 * @Date: 2023/1/1/001 14:58
 * @Description:
 */





/**
 * 全局异常处理类
 *
 */
@ControllerAdvice
public class GlobalExceptionHandler {

//    1.全局异常
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result error(Exception e){
        System.out.println("全局....");
        e.printStackTrace();
        return Result.fail();
    }

    //2 特定异常处理
    @ExceptionHandler(ArithmeticException.class)
    @ResponseBody
    public Result error(ArithmeticException e) {
        System.out.println("特定......");
        e.printStackTrace();
        return Result.fail().message("执行了特定异常处理");
    }

    //3 自定义异常处理
    @ExceptionHandler(UserException.class)
    @ResponseBody
    public Result error(UserException e) {
        e.printStackTrace();
        return Result.fail().code(e.getCode()).message(e.getMsg());
    }



}