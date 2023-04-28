package com.music.permission.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.music.permission.mapper.SysUserMapper;
import com.music.permission.service.SysUserService;
import com.music.permission.vo.LoginVo;
import com.music.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author Administrator
* @description 针对表【sys_user(用户表)】的数据库操作Service实现
* @createDate 2022-12-30 17:21:08
*/
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, UserVo>
implements SysUserService{

    @Autowired
    private SysUserMapper sysUserMapper;


//    @Override
//    public UserVo getUserInfoByUserName(String username) {
//        QueryWrapper<UserVo> wrapper = new QueryWrapper<>();
//        wrapper.eq("username",username);
//
//        return baseMapper.selectOne(wrapper);
//    }
    @Override
    public List<LoginVo> getUserInfoByUserName(String username) {
        return sysUserMapper.loginUser(username);
    }


    @Override
    public List<UserVo> listUser() {
        List<UserVo> userList=  sysUserMapper.listUser();
        return userList;
    }

    //更改用户状态
    @Override
    public void updateStatus(String id, Integer status) {
        //根据用户id查询
        UserVo sysUser = baseMapper.selectById(id);
        //设置修改状态
        sysUser.setStatus(status);
        //调用方法修改
        baseMapper.updateById(sysUser);
    }

    @Override
    public void saveUserRole(UserVo user) {
        String roleId = user.getRoleId();
        Long id = user.getId();
        sysUserMapper.saveUserRole(id,roleId);
    }

    @Override
    public Integer searchSavedUserId(UserVo user) {
        String username = user.getUsername();
        Integer  userId= sysUserMapper.searchSavedUserId(username);
        return userId;
    }

    //根据用户名称获取用户信息（基本信息 和 菜单权限 和 按钮权限数据）
//    @Override
//    public Map<String, Object> getUserInfo(String username) {
//        //根据username查询用户基本信息
//        SysUser sysUser = this.getUserInfoByUserName(username);
//        //根据userid查询菜单权限值
//        List<RouterVo> routerVolist = sysMenuService.getUserMenuList(sysUser.getId());
//        //根据userid查询按钮权限值
//        List<String> permsList = sysMenuService.getUserButtonList(sysUser.getId());
//
//        Map<String,Object> result = new HashMap<>();
//        result.put("name",username);
//        result.put("avatar","https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
//        result.put("roles","[\"admin\"]");
//        //菜单权限数据
//        result.put("routers",routerVolist);
//        //按钮权限数据
//        result.put("buttons",permsList);
//        return result;
//    }

}
