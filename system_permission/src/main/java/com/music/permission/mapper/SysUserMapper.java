package com.music.permission.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.music.permission.vo.LoginVo;
import com.music.vo.UserVo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
* @author Administrator
* @description 针对表【sys_user(用户表)】的数据库操作Mapper
* @createDate 2022-12-30 17:21:08
* @Entity com.music.model.SysUser
*/
@Repository
public interface SysUserMapper extends BaseMapper<UserVo> {

     List<LoginVo>  loginUser(String username) ;

     List<UserVo> listUser() ;

     void saveUserRole(Long id,String roleId);

     Integer  searchSavedUserId(String username);
}
