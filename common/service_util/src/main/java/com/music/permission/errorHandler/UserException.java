package com.music.permission.errorHandler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Auther: Lucas
 * @Date: 2023/1/1/001 15:38
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserException extends RuntimeException{
    private Integer code;
    private String msg;
}