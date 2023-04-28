package com.music.permission.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.music.permission.vo.LoginVo;
import com.music.vo.UserVo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Administrator
 * @description 针对表【sys_user(用户表)】的数据库操作Service
 * @createDate 2022-12-30 17:21:08
 */
@Service
public interface SysUserService extends IService<UserVo> {

    //    UserVo getUserInfoByUserName(String username);
     List<LoginVo> getUserInfoByUserName(String username);

//    Map<String, Object> getUserInfo(String username);

    List<UserVo> listUser();

    //更改用户状态
    void updateStatus(String id, Integer status);

    //    保存用户角色信息
    void saveUserRole(UserVo user);

    //获取刚刚保存的用户id，很有问题
    Integer searchSavedUserId(UserVo user);
}
