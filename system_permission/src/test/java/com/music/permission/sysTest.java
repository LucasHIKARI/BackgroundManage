package com.music.permission;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import com.music.model.SysRole;
import com.music.model.SysUser;
import com.music.permission.mapper.SysRoleMapper;
import com.music.permission.mapper.SysUserMapper;
import com.music.vo.UserVo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @Auther: Lucas
 * @Date: 2022/12/30/030 20:38
 * @Description:
 */
@SpringBootTest
public class sysTest {
    @Autowired
    private SysRoleMapper sysRoleMapper;

    @Autowired
    private SysUserMapper sysUserMapper;

//    @Test
//    public void testFindAll() {
//        List<SysRole> sysRoles = sysRoleMapper.selectList(null);
//        for (SysRole sysRole : sysRoles) {
//            System.out.println(sysRole);
//        }
//    }

    @Test
    public void testFindAllUser() {
        List<UserVo> User = sysUserMapper.selectList(null);
        for (UserVo u : User) {
            System.out.println(u);
        }
    }


    @Test
    public void addUser() {
        UserVo sysUser = new UserVo();
        sysUser.setUsername("测试角色3");
        sysUser.setPassword("testManager2");
        sysUser.setDescription("测试角色3");
        int rows = sysUserMapper.insert(sysUser);
        System.out.println(rows);
    }
//
//    //3 修改操作
//    @Test
//    public void update() {
//        //根据id查询
//        SysRole sysRole = sysRoleMapper.selectById(8);
//
//        //设置修改值
//        sysRole.setDescription("系统管理员11111");
//
//        //调用方法实现修改
//        sysRoleMapper.updateById(sysRole);
//    }
//
//
//    //6 条件查询
//    @Test
//    public void testSelect() {
//        //创建条件构造器对象
//        QueryWrapper<SysRole> wrapper = new QueryWrapper<>();
//        //设置条件
//        //wrapper.eq("role_name","用户管理员");
//        wrapper.like("role_name", "管理员");
//
//        //调用方法查询
//        List<SysRole> list = sysRoleMapper.selectList(wrapper);
//        System.out.println(list);
//
//    }


}